package Sensors;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.example.grpc.temperatureSensor.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Random;

public class TemperatureSensor {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 28001;
        server = ServerBuilder.forPort(port)
                .addService(new TemperatureSensorImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            TemperatureSensor.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    //REGISTER TO CONSUL
    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from consul.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul/temperatureSensor.consul.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final TemperatureSensor server = new TemperatureSensor();
        server.start();
        server.blockUntilShutdown();
    }

    static class TemperatureSensorImpl extends TemperatureSensorConnectionGrpc.TemperatureSensorConnectionImplBase {

        @Override
        public void getTemperatureConnection(TemperatureConnectionRequest request, StreamObserver<TemperatureConnectionResponse> responseObserver) {
            final Random random2 = new Random();
            int temperature = random2.nextInt(45-10+1)+10;
            String message = String.valueOf(temperature);
            TemperatureConnectionResponse response = TemperatureConnectionResponse.newBuilder()
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void streamCurrentTemperature(StreamTemperatureRequest request, StreamObserver<StreamTemperatureResponse> responseObserver) {

            final Random random = new Random();

            Runnable streamingTask = () -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        int temperature = random.nextInt(45-10+1)+10;
                        String message = " is: " + temperature + "°C.";
                        StreamTemperatureResponse response = StreamTemperatureResponse.newBuilder()
                                .setMessage(message)
                                .build();
                        responseObserver.onNext(response);
                        Thread.sleep(10000); // Stream every 10 seconds
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    responseObserver.onCompleted();
                }
            };

            Thread streamingThread = new Thread(streamingTask);
            streamingThread.start();
        }
    }
}

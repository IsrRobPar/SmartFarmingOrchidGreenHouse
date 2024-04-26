package Sensors;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.example.grpc.airHumiditySensor.*;
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

public class AirHumiditySensor {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 28002;
        server = ServerBuilder.forPort(port)
                .addService(new AirHumiditySensor.AirHumiditySensorImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            AirHumiditySensor.this.stop();
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

    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from consul.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul/airHumiditySensor.consul.properties")) {
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
        final AirHumiditySensor server = new AirHumiditySensor();
        server.start();
        server.blockUntilShutdown();
    }

    static class AirHumiditySensorImpl extends AirHumiditySensorConnectionGrpc.AirHumiditySensorConnectionImplBase {

        @Override
        public void getAirHumidityConnection(AirHumidityConnectionRequest request, StreamObserver<AirHumidityConnectionResponse> responseObserver) {
            final Random random2 = new Random();
            int airHumidity = random2.nextInt(45-10+1)+10;
            String message = String.valueOf(airHumidity);
            AirHumidityConnectionResponse response = AirHumidityConnectionResponse.newBuilder()
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void streamCurrentAirHumidity(StreamAirHumidityRequest request, StreamObserver<StreamAirHumidityResponse> responseObserver) {

            final Random random = new Random();

            Runnable streamingTask = () -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        int airHumidity = random.nextInt(45-10+1)+10;
                        String message = " is: " + airHumidity + "%.";
                        StreamAirHumidityResponse response = StreamAirHumidityResponse.newBuilder()
                                .setMessage(message)
                                .build();
                        responseObserver.onNext(response);
                        Thread.sleep(30000); // Stream every 30 seconds
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

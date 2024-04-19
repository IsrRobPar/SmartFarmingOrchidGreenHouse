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
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

public class TemperatureSensorServer {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 28001;
        server = ServerBuilder.forPort(port)
                .addService(new TemperatureSensorServerImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            TemperatureSensorServer.this.stop();
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
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul.temperatureSensorServer.properties")) {
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
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

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
        final TemperatureSensorServer server = new TemperatureSensorServer();
        server.start();
        server.blockUntilShutdown();
    }

    public static class TemperatureSensorServerImpl extends TemperatureSensorServiceGrpc.TemperatureSensorServiceImplBase {

        private final Random random = new Random();

        private int randomTemperature() {
            return (random.nextInt(10));

        }

        int temperature = randomTemperature();

        @Override
        public void getCurrentTemperature(UnaryTemperatureRequest request, StreamObserver<UnaryTemperatureResponse> responseObserver) {
            String message = " is: " + temperature + "°C Current time: " + LocalDateTime.now();
            UnaryTemperatureResponse response = UnaryTemperatureResponse.newBuilder()
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void streamCurrentTemperature(StreamTemperatureRequest request, StreamObserver<StreamTemperatureResponse> responseObserver) {
            Runnable streamingTask = () -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String message = " is: " + temperature + "°C. Current time: " + LocalDateTime.now();
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
package Services;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.example.grpc.fanService.FanServiceGrpc;
import com.example.grpc.fanService.StreamFanStatus;
import com.example.grpc.fanService.StreamTemperatureToFan;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class FanService{
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 28100;
        server = ServerBuilder.forPort(port)
                .addService(new FanServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            FanService.this.stop();
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
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul/fanServiceConsul.properties")) {
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
        final FanService server = new FanService();
        server.start();
        server.blockUntilShutdown();
    }

    static class FanServiceImpl extends FanServiceGrpc.FanServiceImplBase {

        @Override
        public StreamObserver<StreamTemperatureToFan> fanService (StreamObserver<StreamFanStatus> responseObserver) {
            return new StreamObserver<StreamTemperatureToFan>() {

                private boolean FanStatus(int temperature) {
                    return temperature >26;
                }

                @Override
                public void onNext(StreamTemperatureToFan request) {
                    int temperature = request.getTemperature();
                    String fanStatus;

                    if (FanStatus(temperature)) {
                        fanStatus = "active";
                    } else {
                        fanStatus = "not active";
                    }
                    Runnable streamingTask = () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                String message = " Temperature is: " + temperature + " FAN is " + fanStatus;
                                StreamFanStatus response = StreamFanStatus.newBuilder()
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

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client stream completed");
                    responseObserver.onCompleted(); // Complete the response stream
                }
            };
        }
    }
}

package Database;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.example.grpc.recordDataService.RecordDataServiceGrpc;
import com.example.grpc.recordDataService.RecordSensorDataRequest;
import com.example.grpc.recordDataService.RecordSensorDataResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RecordDataSensors {
    private final List<SensorData> recordDataList = new ArrayList<>();

    private Server server;

    private void start() throws IOException {

        /* The port on which the server should run */
        int port = 28500;
        server = ServerBuilder.forPort(port)
                .addService(new RecordDataImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            RecordDataSensors.this.stop();
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
        try (FileInputStream fis = new FileInputStream("src/main/resources/consul/recordDataSensorConsul.properties")) {
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
        final RecordDataSensors server = new RecordDataSensors();
        server.start();
        server.blockUntilShutdown();
    }

    public class RecordDataImpl extends RecordDataServiceGrpc.RecordDataServiceImplBase {
        public StreamObserver<RecordSensorDataRequest> sendRecordData(StreamObserver<RecordSensorDataResponse> responseObserver) {
            return new StreamObserver<RecordSensorDataRequest>() {

                @Override
                public void onNext(RecordSensorDataRequest request) {
                    SensorData sensorData = new SensorData(request.getTemperature(), request.getSoilHumidity());
                    recordDataList.add(sensorData);
                    System.out.println("Record sensor data: " + sensorData);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in Record Data streaming: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Record Data information streaming completed");
                    RecordSensorDataResponse response = RecordSensorDataResponse.newBuilder()
                            .setMessage("Data received successfully")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }

    private static class SensorData {
        private final int temperature;
        private final int soilHumidity;

        public SensorData(int temperature, int soilHumidity) {
            this.temperature = temperature;
            this.soilHumidity = soilHumidity;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getSoilHumidity() {
            return soilHumidity;

        }

        @Override
        public String toString() {
            return "Sensor Data{ " +
                    " temperature = " + temperature +
                    ", soil humidity = " + soilHumidity +
                    " }";
        }

    }


}

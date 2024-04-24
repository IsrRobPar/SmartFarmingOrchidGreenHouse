package Database;

import com.example.grpc.recordDataService.RecordDataServiceGrpc;
import com.example.grpc.recordDataService.RecordSensorDataRequest;
import com.example.grpc.recordDataService.RecordSensorDataResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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



    //ADICIONAR CONSUL REGISTER.


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

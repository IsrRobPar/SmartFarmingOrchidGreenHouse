import com.example.grpc.temperatureSensor.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TemperatureSensor extends TemperatureSensorConnectionGrpc.TemperatureSensorConnectionImplBase {

    @Override
    public void getTemperatureConnection(TemperatureConnectionRequest request, StreamObserver<TemperatureConnectionResponse> responseObserver) {
        String serverName = request.getServerName();
        String message = " -- " + serverName + " -- ";
        TemperatureConnectionResponse response = TemperatureConnectionResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamCurrentTemperature(StreamTemperatureRequest request, StreamObserver<StreamTemperatureResponse> responseObserver) {

        final Random random = new Random();
        int temperature = random.nextInt(100);

        Runnable streamingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
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

    public static void main(String[] args) throws IOException, InterruptedException {
        TemperatureSensor server = new TemperatureSensor();
        Server grpcServer = ServerBuilder.forPort(28001)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Temperature sensor Server started, listening on port 28001");

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));

        grpcServer.awaitTermination();
    }
}

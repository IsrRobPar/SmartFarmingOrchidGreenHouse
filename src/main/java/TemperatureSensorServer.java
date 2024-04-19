import com.example.grpc.temperatureSensor.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class TemperatureSensorServer extends TemperatureSensorServiceGrpc.TemperatureSensorServiceImplBase{
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

    public static void main(String[] args) throws IOException, InterruptedException {
        TemperatureSensorServer server = new TemperatureSensorServer();
        Server grpcServer = ServerBuilder.forPort(28001)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Server started, listening on port 28001");

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Temperature Sensor Server Server");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));

        grpcServer.awaitTermination();
    }
}
import com.example.grpc.humiditySensor.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class HumiditySensorServer extends HumiditySensorServiceGrpc.HumiditySensorServiceImplBase {

    private final Random random = new Random();

    private double randomHumidity() {
        return random.nextDouble() * 100;
    }

    @Override
    public void getCurrentHumidity(UnaryHumidityRequest request, StreamObserver<UnaryHumidityResponse> responseObserver) {
        double humidity = randomHumidity();
        String message = "the Humidity is: " + humidity + "%. Current time: " + LocalDateTime.now();
        UnaryHumidityResponse response = UnaryHumidityResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamCurrentHumidity(StreamHumidityRequest request, StreamObserver<StreamHumidityResponse> responseObserver) {
        double streamHumidity = randomHumidity();
        Runnable streamingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String message = "The Humidity stream is: " + streamHumidity + ". Current time: " + LocalDateTime.now();
                    StreamHumidityResponse response = StreamHumidityResponse.newBuilder()
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
        HumiditySensorServer server = new HumiditySensorServer();
        Server grpcServer = ServerBuilder.forPort(28002)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Server started, listening on port 28002");

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

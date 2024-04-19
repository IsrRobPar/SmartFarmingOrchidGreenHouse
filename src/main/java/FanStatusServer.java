import com.example.grpc.fanStatus.*;
import com.example.grpc.fanStatus.StreamingTemperatureFanStatusGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FanStatusServer extends StreamingTemperatureFanStatusGrpc.StreamingTemperatureFanStatusImplBase {

    @Override
    public StreamObserver<StreamTemperatureToFan> StreamingTemperatureFanStatus(StreamObserver<StreamFanStatus> responseObserver) {
        return new StreamObserver<StreamTemperatureToFan>() {

            @Override
            public void onNext(StreamTemperatureToFan request) {
                System.out.println("Received message from client: " + request.getTemperature());

                // Respond to the client's message with a stream
                int temp = request.getTemperature();
                boolean fanStatus = false;

                if (temp > 28) {
                     fanStatus = true;
                 }
                 {
                    StreamFanStatus response = StreamFanStatus.newBuilder()
                            .setMessage(Boolean.parseBoolean("Response " + fanStatus))
                            .build();


                    responseObserver.onNext(response);
                }
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

    public static void main(String[] args) throws IOException, InterruptedException {
        FanStatusServer server = new FanStatusServer();
        Server grpcServer = ServerBuilder.forPort(28100)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Server started, listening on port 28100");

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Fan Status Sensor Server Server");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));

        grpcServer.awaitTermination();
    }

}
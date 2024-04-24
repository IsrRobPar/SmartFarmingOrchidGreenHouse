package Services;

import com.example.grpc.fanService.FanServiceGrpc;
import com.example.grpc.fanService.StreamFanStatus;
import com.example.grpc.fanService.StreamTemperatureToFan;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FanService extends FanServiceGrpc.FanServiceImplBase {

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

    public static void main(String[] args) throws IOException, InterruptedException {
        FanService server = new FanService();
        Server grpcServer = ServerBuilder.forPort(28100)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Fan Service Server started, listening on port 28100");

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Fan Service Server");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
        grpcServer.awaitTermination();
    }
}

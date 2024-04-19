/*
import com.example.grpc.fanStatus.*;

import com.example.grpc.fanStatus.StreamingTemperatureFanStatusGrpc;
import com.example.grpc.temperatureSensor.UnaryTemperatureRequest;
import com.example.grpc.temperatureSensor.UnaryTemperatureResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FanStatusServer extends StreamingTemperatureFanStatusGrpc.StreamingTemperatureFanStatusImplBase{

    @Override
    public void StreamingTemperatureFanStatus(StreamTemperature request, StreamObserver<StreamFanStatus> responseObserver) {
        String message = " is: " + StreamTemperature + "°C Current time: " + LocalDateTime.now();
        StreamFanStatus response = StreamFanStatus.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
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
*/
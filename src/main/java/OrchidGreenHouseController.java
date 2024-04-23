import com.example.grpc.temperatureSensor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OrchidGreenHouseController {
    private final ManagedChannel channel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionStub stub1;

    public OrchidGreenHouseController(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub1 = TemperatureSensorConnectionGrpc.newStub(channel);
    }

    public void getTemperatureConnection(String serverName) {
        TemperatureConnectionRequest request = TemperatureConnectionRequest.newBuilder()
                .setServerName(serverName)
                .build();

        stub1.getTemperatureConnection(request, new StreamObserver<TemperatureConnectionResponse>() {
            @Override
            public void onNext(TemperatureConnectionResponse response) {
                System.out.println(response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in unary request: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Unary request completed");
            }
        });
    }

    public void streamCurrentTemperature() {
        StreamObserver<StreamTemperatureResponse> responseObserver = new StreamObserver<StreamTemperatureResponse>() {

            @Override
            public void onNext(StreamTemperatureResponse response) {
                System.out.println("TEMPERATURE " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in server streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Server streaming completed");
            }
        };

        stub1.streamCurrentTemperature(StreamTemperatureRequest.newBuilder().setTemperature(0).build(), responseObserver);

    }


    public static void main(String[] args) {
        OrchidGreenHouseController client = new OrchidGreenHouseController("localhost", 28001);
        client.getTemperatureConnection("Temperature Sensor");
        client.streamCurrentTemperature();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 'Q' to quit");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                client.shutdown();
                break;
            }
        }
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }
}

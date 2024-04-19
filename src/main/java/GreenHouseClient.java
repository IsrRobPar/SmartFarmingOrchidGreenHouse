import com.example.grpc.humiditySensor.*;
import com.example.grpc.temperatureSensor.*;
import com.example.grpc.fanStatus.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GreenHouseClient {
    private final ManagedChannel channel;
    private final HumiditySensorServiceGrpc.HumiditySensorServiceStub stub;
    private final TemperatureSensorServiceGrpc.TemperatureSensorServiceStub stub2;
   // private final StreamingTemperatureFanStatusGrpc.StreamingTemperatureFanStatusStub stub3;


    public GreenHouseClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = HumiditySensorServiceGrpc.newStub(channel);
        this.stub2 = TemperatureSensorServiceGrpc.newStub(channel);
       // this.stub3 = StreamingTemperatureFanStatusGrpc.newStub(channel);
    }

    //HUMIDITY SERVER SERVICE
    public void getCurrentHumidity(double humidity) {
        UnaryHumidityRequest request = UnaryHumidityRequest.newBuilder()
                .setHumidity(humidity)
                .build();
        stub.getCurrentHumidity(request, new StreamObserver<UnaryHumidityResponse>() {
            @Override
            public void onNext(UnaryHumidityResponse response) {
                System.out.println("HUMIDITY: " + response.getMessage());
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

    public void streamHumidityRequest() {
        StreamObserver<StreamHumidityResponse> responseObserver = new StreamObserver<StreamHumidityResponse>() {
            @Override
            public void onNext(StreamHumidityResponse response) {
                System.out.println("HUMIDITY Streaming: " + response.getMessage());
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
        stub.streamCurrentHumidity(StreamHumidityRequest.newBuilder().setHumidity(50).build(), responseObserver);

    }

    //TEMPERATURE SERVER SERVICE
    public void getCurrentTemperature(int temperature) {
        UnaryTemperatureRequest request = UnaryTemperatureRequest.newBuilder()
                .setTemperature(temperature)
                .build();
        stub2.getCurrentTemperature(request, new StreamObserver<UnaryTemperatureResponse>() {
            @Override
            public void onNext(UnaryTemperatureResponse response) {
                System.out.println("TEMPERATURE: " + response.getMessage());
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

    public void streamTemperatureRequest() {
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
        stub2.streamCurrentTemperature(StreamTemperatureRequest.newBuilder().setTemperature(50).build(), responseObserver);

    }

    //FAN STATUS SERVICE



    //MAIN
    public static void main(String[] args) {
        GreenHouseClient client = new GreenHouseClient("localhost", 28001);
        client.getCurrentTemperature(50);
        client.streamTemperatureRequest();

        GreenHouseClient client2 = new GreenHouseClient("localhost", 28002);
        client2.getCurrentHumidity(50);
        client2.streamHumidityRequest();

       // GreenHouseClient client3 = new GreenHouseClient("localhost", 28100);
        //client3.getCurrentHumidity(50);

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


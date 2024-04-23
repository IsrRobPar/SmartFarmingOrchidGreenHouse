import com.example.grpc.fanService.*;
import com.example.grpc.temperatureSensor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OrchidGreenHouseController {
    private final ManagedChannel channel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionStub temperatureSensorStub;
    private final FanServiceGrpc.FanServiceStub fanServiceStub;

    public OrchidGreenHouseController(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.temperatureSensorStub = TemperatureSensorConnectionGrpc.newStub(channel);
        this.fanServiceStub = FanServiceGrpc.newStub(channel);
    }

    //TEMPERATURE SENSOR (SERVER-SIDE STREAMING GRPC)
    public void getTemperatureConnection(String serverName) {
        TemperatureConnectionRequest request = TemperatureConnectionRequest.newBuilder()
                .setServerName(serverName)
                .build();

        temperatureSensorStub.getTemperatureConnection(request, new StreamObserver<TemperatureConnectionResponse>() {
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
                System.out.println("Temperature Sensor request completed");
            }
        });
    }

    public void streamCurrentTemperature() {
        StreamObserver<StreamTemperatureResponse> responseObserver = new StreamObserver<StreamTemperatureResponse>() {

            @Override
            public void onNext(StreamTemperatureResponse response) {
                System.out.println("TEMPERATURE streaming " + response.getMessage());
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

        temperatureSensorStub.streamCurrentTemperature(StreamTemperatureRequest.newBuilder().setTemperature(0).build(), responseObserver);
    }

    //FAN SERVICE (BIDIRECTIONAL STREAMING GRPC)
    public void fanService() {
        StreamObserver<StreamFanStatus> responseObserver = new StreamObserver<StreamFanStatus>() {
            @Override
            public void onNext(StreamFanStatus value) {
                System.out.println("-----------------------------------" +
                                  "\nFAN status: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Server stream completed");
            }
        };

        StreamObserver<StreamTemperatureToFan> requestObserver = fanServiceStub.fanService(responseObserver);

        Random random = new Random();
        int temperature = random.nextInt(100);

        StreamTemperatureToFan request = StreamTemperatureToFan.newBuilder()
                .setTemperature(temperature)
                .build();

        System.out.println("Sending temperature: " + temperature);
        requestObserver.onNext(request);
    }



    public static void main(String[] args) {
        OrchidGreenHouseController clientTemperatureSensor = new OrchidGreenHouseController("localhost", 28001);
        clientTemperatureSensor.getTemperatureConnection("Temperature Sensor");
        clientTemperatureSensor.streamCurrentTemperature();

        OrchidGreenHouseController clientFanService = new OrchidGreenHouseController("localhost", 28100);
        clientFanService.fanService();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 'Q' to quit");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                clientTemperatureSensor.shutdown();
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

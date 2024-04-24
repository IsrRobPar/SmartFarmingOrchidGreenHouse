import com.example.grpc.fanService.*;
import com.example.grpc.recordDataService.*;
import com.example.grpc.temperatureSensor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OrchidGreenHouseController {
    private final ManagedChannel channel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionStub temperatureSensorStub;
    private final FanServiceGrpc.FanServiceStub fanServiceStub;
    private final RecordDataServiceGrpc.RecordDataServiceStub recordDataServiceStub;

    public OrchidGreenHouseController(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.temperatureSensorStub = TemperatureSensorConnectionGrpc.newStub(channel);
        this.fanServiceStub = FanServiceGrpc.newStub(channel);
        this.recordDataServiceStub = RecordDataServiceGrpc.newStub(channel);
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

    //RECORD DATA SERVICE (CLIENT_SIDE STREAMING GRPC)
    public void recordDataService() {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<RecordSensorDataRequest> requestObserver = recordDataServiceStub.sendRecordData(new StreamObserver<RecordSensorDataResponse>() {
            @Override
            public void onNext(RecordSensorDataResponse response) {
                System.out.println("Received Record Data response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {

                System.err.println("Error in streaming record data: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming Record Data request completed");
            }

        });

        try {
            // Simulate sending sensor data
            requestObserver.onNext(RecordSensorDataRequest.newBuilder()
                    .setTemperature(25)
                    .setSoilHumidity(60)
                    .build());

            // Sleep for 1 second between sending each data point
            Thread.sleep(1000);

            requestObserver.onNext(RecordSensorDataRequest.newBuilder()
                    .setTemperature(29)
                    .setSoilHumidity(50)
                    .build());

            requestObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.shutdown();

    }


    public static void main(String[] args) {
        OrchidGreenHouseController clientTemperatureSensor = new OrchidGreenHouseController("localhost", 28001);
        clientTemperatureSensor.getTemperatureConnection("Temperature Sensor");
        clientTemperatureSensor.streamCurrentTemperature();

        OrchidGreenHouseController clientFanService = new OrchidGreenHouseController("localhost", 28100);
        clientFanService.fanService();

        OrchidGreenHouseController clientRecordDataService = new OrchidGreenHouseController("localhost", 28500);
        clientRecordDataService.recordDataService();

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

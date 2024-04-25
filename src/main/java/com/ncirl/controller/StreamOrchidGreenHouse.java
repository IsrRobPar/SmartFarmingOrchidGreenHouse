package com.ncirl.controller;

import com.example.grpc.fanService.FanServiceGrpc;
import com.example.grpc.fanService.StreamFanStatus;
import com.example.grpc.fanService.StreamTemperatureToFan;
import com.example.grpc.recordDataService.RecordDataServiceGrpc;
import com.example.grpc.recordDataService.RecordSensorDataRequest;
import com.example.grpc.recordDataService.RecordSensorDataResponse;
import com.example.grpc.temperatureSensor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StreamOrchidGreenHouse {

    //GUI
    @FXML
    public TextField nameTextField;

    @FXML
    public Button submitButton;

    @FXML
    void submitButtonClickOnAction(ActionEvent event) {
        System.out.println("SubmitButtonClickOnAction clicked");
        String name = nameTextField.getText();
        System.out.println("nameTextField: " + name);
    }










    private final ManagedChannel channel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionStub temperatureSensorStub;
    private final FanServiceGrpc.FanServiceStub fanServiceStub;
    private final RecordDataServiceGrpc.RecordDataServiceStub recordDataServiceStub;

    public StreamOrchidGreenHouse(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.temperatureSensorStub = TemperatureSensorConnectionGrpc.newStub(channel);
        this.fanServiceStub = FanServiceGrpc.newStub(channel);
        this.recordDataServiceStub = RecordDataServiceGrpc.newStub(channel);
    }

    //TEMPERATURE SENSOR (SERVER-SIDE STREAMING GRPC)
    public void getTemperatureConnection(int temperature) {
        TemperatureConnectionRequest request = TemperatureConnectionRequest.newBuilder()
                .setTemperature(temperature)
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
            Thread.sleep(2000);

            requestObserver.onNext(RecordSensorDataRequest.newBuilder()
                    .setTemperature(29)
                    .setSoilHumidity(50)
                    .build());

            // Sleep for 1 second between sending each data point
            Thread.sleep(2000);

            requestObserver.onNext(RecordSensorDataRequest.newBuilder()
                    .setTemperature(29)
                    .setSoilHumidity(50)
                    .build());

            // Sleep for 1 second between sending each data point
            Thread.sleep(2000);

            requestObserver.onNext(RecordSensorDataRequest.newBuilder()
                    .setTemperature(25)
                    .setSoilHumidity(60)
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
        StreamOrchidGreenHouse clientTemperatureSensor = new StreamOrchidGreenHouse("localhost", 28001);
        clientTemperatureSensor.getTemperatureConnection(0);
        clientTemperatureSensor.streamCurrentTemperature();

        StreamOrchidGreenHouse clientFanService = new StreamOrchidGreenHouse("localhost", 28100);
        clientFanService.fanService();

        StreamOrchidGreenHouse clientRecordDataService = new StreamOrchidGreenHouse("localhost", 28500);
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
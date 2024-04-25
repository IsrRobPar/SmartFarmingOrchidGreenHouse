
package com.ncirl.controller;

import com.example.grpc.temperatureSensor.TemperatureConnectionRequest;
import com.example.grpc.temperatureSensor.TemperatureConnectionResponse;
import com.example.grpc.temperatureSensor.TemperatureSensorConnectionGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class SmartGreenHouseFormController {

    private final ManagedChannel UnaryTemperatureChannel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionBlockingStub UnaryTemperatureSensorStub;

    @FXML
    private Label temperatureLabel;

    public SmartGreenHouseFormController() {
        this.UnaryTemperatureChannel = ManagedChannelBuilder.forAddress("localhost", 28001)
                .usePlaintext()
                .build();
        this.UnaryTemperatureSensorStub = TemperatureSensorConnectionGrpc.newBlockingStub(UnaryTemperatureChannel);
    }

    @FXML
    void initialize() {    }

    public void getTemperatureConnection() {
        TemperatureConnectionRequest request = TemperatureConnectionRequest.newBuilder()
                .setTemperature(0)
                .build();

        TemperatureConnectionResponse response;

        try {
            response = UnaryTemperatureSensorStub.getTemperatureConnection(request);
            System.out.println(response.getMessage());
            temperatureLabel.setText("Temperature: " + response.getMessage() + " °C");
        } catch (Exception e) {
            System.err.println("Error in unary request: " + e.getMessage());
        }
    }

    @FXML
    public void updateTemperature(ActionEvent event) {
        System.out.println("Temperature Button Clicked");
        getTemperatureConnection();
    }

}

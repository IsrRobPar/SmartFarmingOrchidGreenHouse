
package com.ncirl.controller;

import com.example.grpc.temperatureSensor.*;
import com.example.grpc.airHumiditySensor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class SmartGreenHouseFormController {

    private final ManagedChannel UnaryTemperatureChannel;
    private final TemperatureSensorConnectionGrpc.TemperatureSensorConnectionBlockingStub UnaryTemperatureSensorStub;

    private final ManagedChannel UnaryAirHumidityChannel;
    private final AirHumiditySensorConnectionGrpc.AirHumiditySensorConnectionBlockingStub UnaryAirHumiditySensorStub;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label airHumidityLabel;

    public SmartGreenHouseFormController() {
        this.UnaryTemperatureChannel = ManagedChannelBuilder.forAddress("localhost", 28001)
                .usePlaintext()
                .build();
        this.UnaryTemperatureSensorStub = TemperatureSensorConnectionGrpc.newBlockingStub(UnaryTemperatureChannel);

        this.UnaryAirHumidityChannel = ManagedChannelBuilder.forAddress("localhost", 28002)
                .usePlaintext()
                .build();
        this.UnaryAirHumiditySensorStub = AirHumiditySensorConnectionGrpc.newBlockingStub(UnaryAirHumidityChannel);
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
            temperatureLabel.setText(response.getMessage() + "°C");
        } catch (Exception e) {
            System.err.println("Error in unary request: " + e.getMessage());
        }
    }

    @FXML
    public void updateTemperature(ActionEvent event) {
        System.out.println("Temperature Button Clicked");
        getTemperatureConnection();
    }

    public void getAirHumidityConnection() {
        AirHumidityConnectionRequest request = AirHumidityConnectionRequest.newBuilder()
                .setAirHumidity(0)
                .build();

        AirHumidityConnectionResponse response;

        try {
            response = UnaryAirHumiditySensorStub.getAirHumidityConnection(request);
            System.out.println(response.getMessage());
            airHumidityLabel.setText(response.getMessage() + "%");
        } catch (Exception e) {
            System.err.println("Error in unary request: " + e.getMessage());
        }
    }

    @FXML
    public void updateAirHumidity(ActionEvent event) {
        System.out.println("Air Humidity Button Clicked");
        getAirHumidityConnection();
    }

}

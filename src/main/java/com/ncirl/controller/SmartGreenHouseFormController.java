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

public class SmartGreenHouseFormController {

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
}






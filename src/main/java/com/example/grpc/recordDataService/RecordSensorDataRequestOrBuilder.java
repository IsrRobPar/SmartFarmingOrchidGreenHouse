// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: recordData.proto

package com.example.grpc.recordDataService;

public interface RecordSensorDataRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.grpc.recordDataService.RecordSensorDataRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 temperature = 1;</code>
   */
  int getTemperature();

  /**
   * <code>int32 soilHumidity = 2;</code>
   */
  int getSoilHumidity();

  /**
   * <code>string dateTime = 3;</code>
   */
  java.lang.String getDateTime();
  /**
   * <code>string dateTime = 3;</code>
   */
  com.google.protobuf.ByteString
      getDateTimeBytes();
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: airHumiditySensor.proto

package com.example.grpc.airHumiditySensor;

public final class airHumidityProto {
  private airHumidityProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027airHumiditySensor.proto\022\"com.example.g" +
      "rpc.airHumiditySensor\"3\n\034AirHumidityConn" +
      "ectionRequest\022\023\n\013airHumidity\030\001 \001(\005\"0\n\035Ai" +
      "rHumidityConnectionResponse\022\017\n\007message\030\001" +
      " \001(\t\"/\n\030StreamAirHumidityRequest\022\023\n\013airH" +
      "umidity\030\001 \001(\005\"A\n\031StreamAirHumidityRespon" +
      "se\022\017\n\007message\030\001 \001(\t\022\023\n\013temperature\030\002 \001(\005" +
      "2\333\002\n\033AirHumiditySensorConnection\022\237\001\n\030get" +
      "AirHumidityConnection\022@.com.example.grpc" +
      ".airHumiditySensor.AirHumidityConnection" +
      "Request\032A.com.example.grpc.airHumiditySe" +
      "nsor.AirHumidityConnectionResponse\022\231\001\n\030s" +
      "treamCurrentAirHumidity\022<.com.example.gr" +
      "pc.airHumiditySensor.StreamAirHumidityRe" +
      "quest\032=.com.example.grpc.airHumiditySens" +
      "or.StreamAirHumidityResponse0\001B8\n\"com.ex" +
      "ample.grpc.airHumiditySensorB\020airHumidit" +
      "yProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionRequest_descriptor,
        new java.lang.String[] { "AirHumidity", });
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_airHumiditySensor_AirHumidityConnectionResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityRequest_descriptor,
        new java.lang.String[] { "AirHumidity", });
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_airHumiditySensor_StreamAirHumidityResponse_descriptor,
        new java.lang.String[] { "Message", "Temperature", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

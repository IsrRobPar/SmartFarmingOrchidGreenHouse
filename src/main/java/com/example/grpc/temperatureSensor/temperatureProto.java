// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: temperatureSensor.proto

package com.example.grpc.temperatureSensor;

public final class temperatureProto {
  private temperatureProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_temperatureSensor_StreamTemperatureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_temperatureSensor_StreamTemperatureResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027temperatureSensor.proto\022\"com.example.g" +
      "rpc.temperatureSensor\".\n\027UnaryTemperatur" +
      "eRequest\022\023\n\013temperature\030\001 \001(\001\"+\n\030UnaryTe" +
      "mperatureResponse\022\017\n\007message\030\001 \001(\t\"5\n\030St" +
      "reamTemperatureRequest\022\031\n\021streamTemperat" +
      "ure\030\001 \001(\001\",\n\031StreamTemperatureResponse\022\017" +
      "\n\007message\030\001 \001(\t2\313\002\n\030TemperatureSensorSer" +
      "vice\022\222\001\n\025getCurrentTemperature\022;.com.exa" +
      "mple.grpc.temperatureSensor.UnaryTempera" +
      "tureRequest\032<.com.example.grpc.temperatu" +
      "reSensor.UnaryTemperatureResponse\022\231\001\n\030st" +
      "reamCurrentTemperature\022<.com.example.grp" +
      "c.temperatureSensor.StreamTemperatureReq" +
      "uest\032=.com.example.grpc.temperatureSenso" +
      "r.StreamTemperatureResponse0\001B8\n\"com.exa" +
      "mple.grpc.temperatureSensorB\020temperature" +
      "ProtoP\001b\006proto3"
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
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureRequest_descriptor,
        new java.lang.String[] { "Temperature", });
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_temperatureSensor_UnaryTemperatureResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_temperatureSensor_StreamTemperatureRequest_descriptor,
        new java.lang.String[] { "StreamTemperature", });
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_example_grpc_temperatureSensor_StreamTemperatureResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_temperatureSensor_StreamTemperatureResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
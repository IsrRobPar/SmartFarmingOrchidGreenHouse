// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: recordData.proto

package com.example.grpc.recordDataService;

public final class recordDataServiceProto {
  private recordDataServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_recordDataService_RecordSensorDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_recordDataService_RecordSensorDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_recordDataService_RecordSensorDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_recordDataService_RecordSensorDataResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020recordData.proto\022\"com.example.grpc.rec" +
      "ordDataService\"D\n\027RecordSensorDataReques" +
      "t\022\023\n\013temperature\030\001 \001(\005\022\024\n\014soilHumidity\030\002" +
      " \001(\005\"+\n\030RecordSensorDataResponse\022\017\n\007mess" +
      "age\030\001 \001(\t2\243\001\n\021RecordDataService\022\215\001\n\016send" +
      "RecordData\022;.com.example.grpc.recordData" +
      "Service.RecordSensorDataRequest\032<.com.ex" +
      "ample.grpc.recordDataService.RecordSenso" +
      "rDataResponse(\001B>\n\"com.example.grpc.reco" +
      "rdDataServiceB\026recordDataServiceProtoP\001b" +
      "\006proto3"
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
    internal_static_com_example_grpc_recordDataService_RecordSensorDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_grpc_recordDataService_RecordSensorDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_recordDataService_RecordSensorDataRequest_descriptor,
        new java.lang.String[] { "Temperature", "SoilHumidity", });
    internal_static_com_example_grpc_recordDataService_RecordSensorDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_grpc_recordDataService_RecordSensorDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_recordDataService_RecordSensorDataResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

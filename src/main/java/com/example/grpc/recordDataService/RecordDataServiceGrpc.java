package com.example.grpc.recordDataService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: recordData.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecordDataServiceGrpc {

  private RecordDataServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.recordDataService.RecordDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.recordDataService.RecordSensorDataRequest,
      com.example.grpc.recordDataService.RecordSensorDataResponse> getSendRecordDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendRecordData",
      requestType = com.example.grpc.recordDataService.RecordSensorDataRequest.class,
      responseType = com.example.grpc.recordDataService.RecordSensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.recordDataService.RecordSensorDataRequest,
      com.example.grpc.recordDataService.RecordSensorDataResponse> getSendRecordDataMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.recordDataService.RecordSensorDataRequest, com.example.grpc.recordDataService.RecordSensorDataResponse> getSendRecordDataMethod;
    if ((getSendRecordDataMethod = RecordDataServiceGrpc.getSendRecordDataMethod) == null) {
      synchronized (RecordDataServiceGrpc.class) {
        if ((getSendRecordDataMethod = RecordDataServiceGrpc.getSendRecordDataMethod) == null) {
          RecordDataServiceGrpc.getSendRecordDataMethod = getSendRecordDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.recordDataService.RecordSensorDataRequest, com.example.grpc.recordDataService.RecordSensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendRecordData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.recordDataService.RecordSensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.recordDataService.RecordSensorDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecordDataServiceMethodDescriptorSupplier("sendRecordData"))
              .build();
        }
      }
    }
    return getSendRecordDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecordDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceStub>() {
        @java.lang.Override
        public RecordDataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecordDataServiceStub(channel, callOptions);
        }
      };
    return RecordDataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecordDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceBlockingStub>() {
        @java.lang.Override
        public RecordDataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecordDataServiceBlockingStub(channel, callOptions);
        }
      };
    return RecordDataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecordDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecordDataServiceFutureStub>() {
        @java.lang.Override
        public RecordDataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecordDataServiceFutureStub(channel, callOptions);
        }
      };
    return RecordDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpc.recordDataService.RecordSensorDataRequest> sendRecordData(
        io.grpc.stub.StreamObserver<com.example.grpc.recordDataService.RecordSensorDataResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendRecordDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RecordDataService.
   */
  public static abstract class RecordDataServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RecordDataServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RecordDataService.
   */
  public static final class RecordDataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecordDataServiceStub> {
    private RecordDataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecordDataServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.recordDataService.RecordSensorDataRequest> sendRecordData(
        io.grpc.stub.StreamObserver<com.example.grpc.recordDataService.RecordSensorDataResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendRecordDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RecordDataService.
   */
  public static final class RecordDataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecordDataServiceBlockingStub> {
    private RecordDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecordDataServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RecordDataService.
   */
  public static final class RecordDataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecordDataServiceFutureStub> {
    private RecordDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecordDataServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_RECORD_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_RECORD_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendRecordData(
              (io.grpc.stub.StreamObserver<com.example.grpc.recordDataService.RecordSensorDataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendRecordDataMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.example.grpc.recordDataService.RecordSensorDataRequest,
              com.example.grpc.recordDataService.RecordSensorDataResponse>(
                service, METHODID_SEND_RECORD_DATA)))
        .build();
  }

  private static abstract class RecordDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecordDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.recordDataService.recordDataServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecordDataService");
    }
  }

  private static final class RecordDataServiceFileDescriptorSupplier
      extends RecordDataServiceBaseDescriptorSupplier {
    RecordDataServiceFileDescriptorSupplier() {}
  }

  private static final class RecordDataServiceMethodDescriptorSupplier
      extends RecordDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecordDataServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RecordDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecordDataServiceFileDescriptorSupplier())
              .addMethod(getSendRecordDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.example.grpc.airHumiditySensor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: airHumiditySensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AirHumiditySensorConnectionGrpc {

  private AirHumiditySensorConnectionGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.airHumiditySensor.AirHumiditySensorConnection";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest,
      com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> getGetAirHumidityConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAirHumidityConnection",
      requestType = com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest.class,
      responseType = com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest,
      com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> getGetAirHumidityConnectionMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest, com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> getGetAirHumidityConnectionMethod;
    if ((getGetAirHumidityConnectionMethod = AirHumiditySensorConnectionGrpc.getGetAirHumidityConnectionMethod) == null) {
      synchronized (AirHumiditySensorConnectionGrpc.class) {
        if ((getGetAirHumidityConnectionMethod = AirHumiditySensorConnectionGrpc.getGetAirHumidityConnectionMethod) == null) {
          AirHumiditySensorConnectionGrpc.getGetAirHumidityConnectionMethod = getGetAirHumidityConnectionMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest, com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAirHumidityConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirHumiditySensorConnectionMethodDescriptorSupplier("getAirHumidityConnection"))
              .build();
        }
      }
    }
    return getGetAirHumidityConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.StreamAirHumidityRequest,
      com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> getStreamCurrentAirHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamCurrentAirHumidity",
      requestType = com.example.grpc.airHumiditySensor.StreamAirHumidityRequest.class,
      responseType = com.example.grpc.airHumiditySensor.StreamAirHumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.StreamAirHumidityRequest,
      com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> getStreamCurrentAirHumidityMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.airHumiditySensor.StreamAirHumidityRequest, com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> getStreamCurrentAirHumidityMethod;
    if ((getStreamCurrentAirHumidityMethod = AirHumiditySensorConnectionGrpc.getStreamCurrentAirHumidityMethod) == null) {
      synchronized (AirHumiditySensorConnectionGrpc.class) {
        if ((getStreamCurrentAirHumidityMethod = AirHumiditySensorConnectionGrpc.getStreamCurrentAirHumidityMethod) == null) {
          AirHumiditySensorConnectionGrpc.getStreamCurrentAirHumidityMethod = getStreamCurrentAirHumidityMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.airHumiditySensor.StreamAirHumidityRequest, com.example.grpc.airHumiditySensor.StreamAirHumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamCurrentAirHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.airHumiditySensor.StreamAirHumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.airHumiditySensor.StreamAirHumidityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirHumiditySensorConnectionMethodDescriptorSupplier("streamCurrentAirHumidity"))
              .build();
        }
      }
    }
    return getStreamCurrentAirHumidityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirHumiditySensorConnectionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionStub>() {
        @java.lang.Override
        public AirHumiditySensorConnectionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirHumiditySensorConnectionStub(channel, callOptions);
        }
      };
    return AirHumiditySensorConnectionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirHumiditySensorConnectionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionBlockingStub>() {
        @java.lang.Override
        public AirHumiditySensorConnectionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirHumiditySensorConnectionBlockingStub(channel, callOptions);
        }
      };
    return AirHumiditySensorConnectionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirHumiditySensorConnectionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirHumiditySensorConnectionFutureStub>() {
        @java.lang.Override
        public AirHumiditySensorConnectionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirHumiditySensorConnectionFutureStub(channel, callOptions);
        }
      };
    return AirHumiditySensorConnectionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void getAirHumidityConnection(com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAirHumidityConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    default void streamCurrentAirHumidity(com.example.grpc.airHumiditySensor.StreamAirHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCurrentAirHumidityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AirHumiditySensorConnection.
   */
  public static abstract class AirHumiditySensorConnectionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AirHumiditySensorConnectionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AirHumiditySensorConnection.
   */
  public static final class AirHumiditySensorConnectionStub
      extends io.grpc.stub.AbstractAsyncStub<AirHumiditySensorConnectionStub> {
    private AirHumiditySensorConnectionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirHumiditySensorConnectionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirHumiditySensorConnectionStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void getAirHumidityConnection(com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAirHumidityConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public void streamCurrentAirHumidity(com.example.grpc.airHumiditySensor.StreamAirHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCurrentAirHumidityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AirHumiditySensorConnection.
   */
  public static final class AirHumiditySensorConnectionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AirHumiditySensorConnectionBlockingStub> {
    private AirHumiditySensorConnectionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirHumiditySensorConnectionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirHumiditySensorConnectionBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse getAirHumidityConnection(com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAirHumidityConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public java.util.Iterator<com.example.grpc.airHumiditySensor.StreamAirHumidityResponse> streamCurrentAirHumidity(
        com.example.grpc.airHumiditySensor.StreamAirHumidityRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCurrentAirHumidityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AirHumiditySensorConnection.
   */
  public static final class AirHumiditySensorConnectionFutureStub
      extends io.grpc.stub.AbstractFutureStub<AirHumiditySensorConnectionFutureStub> {
    private AirHumiditySensorConnectionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirHumiditySensorConnectionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirHumiditySensorConnectionFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse> getAirHumidityConnection(
        com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAirHumidityConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AIR_HUMIDITY_CONNECTION = 0;
  private static final int METHODID_STREAM_CURRENT_AIR_HUMIDITY = 1;

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
        case METHODID_GET_AIR_HUMIDITY_CONNECTION:
          serviceImpl.getAirHumidityConnection((com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse>) responseObserver);
          break;
        case METHODID_STREAM_CURRENT_AIR_HUMIDITY:
          serviceImpl.streamCurrentAirHumidity((com.example.grpc.airHumiditySensor.StreamAirHumidityRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.airHumiditySensor.StreamAirHumidityResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAirHumidityConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.airHumiditySensor.AirHumidityConnectionRequest,
              com.example.grpc.airHumiditySensor.AirHumidityConnectionResponse>(
                service, METHODID_GET_AIR_HUMIDITY_CONNECTION)))
        .addMethod(
          getStreamCurrentAirHumidityMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpc.airHumiditySensor.StreamAirHumidityRequest,
              com.example.grpc.airHumiditySensor.StreamAirHumidityResponse>(
                service, METHODID_STREAM_CURRENT_AIR_HUMIDITY)))
        .build();
  }

  private static abstract class AirHumiditySensorConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirHumiditySensorConnectionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.airHumiditySensor.airHumidityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirHumiditySensorConnection");
    }
  }

  private static final class AirHumiditySensorConnectionFileDescriptorSupplier
      extends AirHumiditySensorConnectionBaseDescriptorSupplier {
    AirHumiditySensorConnectionFileDescriptorSupplier() {}
  }

  private static final class AirHumiditySensorConnectionMethodDescriptorSupplier
      extends AirHumiditySensorConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AirHumiditySensorConnectionMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AirHumiditySensorConnectionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirHumiditySensorConnectionFileDescriptorSupplier())
              .addMethod(getGetAirHumidityConnectionMethod())
              .addMethod(getStreamCurrentAirHumidityMethod())
              .build();
        }
      }
    }
    return result;
  }
}

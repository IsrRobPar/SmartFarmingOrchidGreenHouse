package com.example.grpc.temperatureSensor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: temperatureSensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TemperatureSensorConnectionGrpc {

  private TemperatureSensorConnectionGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.temperatureSensor.TemperatureSensorConnection";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.TemperatureConnectionRequest,
      com.example.grpc.temperatureSensor.TemperatureConnectionResponse> getGetTemperatureConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTemperatureConnection",
      requestType = com.example.grpc.temperatureSensor.TemperatureConnectionRequest.class,
      responseType = com.example.grpc.temperatureSensor.TemperatureConnectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.TemperatureConnectionRequest,
      com.example.grpc.temperatureSensor.TemperatureConnectionResponse> getGetTemperatureConnectionMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.TemperatureConnectionRequest, com.example.grpc.temperatureSensor.TemperatureConnectionResponse> getGetTemperatureConnectionMethod;
    if ((getGetTemperatureConnectionMethod = TemperatureSensorConnectionGrpc.getGetTemperatureConnectionMethod) == null) {
      synchronized (TemperatureSensorConnectionGrpc.class) {
        if ((getGetTemperatureConnectionMethod = TemperatureSensorConnectionGrpc.getGetTemperatureConnectionMethod) == null) {
          TemperatureSensorConnectionGrpc.getGetTemperatureConnectionMethod = getGetTemperatureConnectionMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.temperatureSensor.TemperatureConnectionRequest, com.example.grpc.temperatureSensor.TemperatureConnectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getTemperatureConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.TemperatureConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.TemperatureConnectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureSensorConnectionMethodDescriptorSupplier("getTemperatureConnection"))
              .build();
        }
      }
    }
    return getGetTemperatureConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.StreamTemperatureRequest,
      com.example.grpc.temperatureSensor.StreamTemperatureResponse> getStreamCurrentTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamCurrentTemperature",
      requestType = com.example.grpc.temperatureSensor.StreamTemperatureRequest.class,
      responseType = com.example.grpc.temperatureSensor.StreamTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.StreamTemperatureRequest,
      com.example.grpc.temperatureSensor.StreamTemperatureResponse> getStreamCurrentTemperatureMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.StreamTemperatureRequest, com.example.grpc.temperatureSensor.StreamTemperatureResponse> getStreamCurrentTemperatureMethod;
    if ((getStreamCurrentTemperatureMethod = TemperatureSensorConnectionGrpc.getStreamCurrentTemperatureMethod) == null) {
      synchronized (TemperatureSensorConnectionGrpc.class) {
        if ((getStreamCurrentTemperatureMethod = TemperatureSensorConnectionGrpc.getStreamCurrentTemperatureMethod) == null) {
          TemperatureSensorConnectionGrpc.getStreamCurrentTemperatureMethod = getStreamCurrentTemperatureMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.temperatureSensor.StreamTemperatureRequest, com.example.grpc.temperatureSensor.StreamTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.StreamTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.StreamTemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureSensorConnectionMethodDescriptorSupplier("streamCurrentTemperature"))
              .build();
        }
      }
    }
    return getStreamCurrentTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureSensorConnectionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionStub>() {
        @java.lang.Override
        public TemperatureSensorConnectionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorConnectionStub(channel, callOptions);
        }
      };
    return TemperatureSensorConnectionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureSensorConnectionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionBlockingStub>() {
        @java.lang.Override
        public TemperatureSensorConnectionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorConnectionBlockingStub(channel, callOptions);
        }
      };
    return TemperatureSensorConnectionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureSensorConnectionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorConnectionFutureStub>() {
        @java.lang.Override
        public TemperatureSensorConnectionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorConnectionFutureStub(channel, callOptions);
        }
      };
    return TemperatureSensorConnectionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void getTemperatureConnection(com.example.grpc.temperatureSensor.TemperatureConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.TemperatureConnectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTemperatureConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    default void streamCurrentTemperature(com.example.grpc.temperatureSensor.StreamTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.StreamTemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCurrentTemperatureMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TemperatureSensorConnection.
   */
  public static abstract class TemperatureSensorConnectionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TemperatureSensorConnectionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TemperatureSensorConnection.
   */
  public static final class TemperatureSensorConnectionStub
      extends io.grpc.stub.AbstractAsyncStub<TemperatureSensorConnectionStub> {
    private TemperatureSensorConnectionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorConnectionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorConnectionStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void getTemperatureConnection(com.example.grpc.temperatureSensor.TemperatureConnectionRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.TemperatureConnectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTemperatureConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public void streamCurrentTemperature(com.example.grpc.temperatureSensor.StreamTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.StreamTemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCurrentTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TemperatureSensorConnection.
   */
  public static final class TemperatureSensorConnectionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TemperatureSensorConnectionBlockingStub> {
    private TemperatureSensorConnectionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorConnectionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorConnectionBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.example.grpc.temperatureSensor.TemperatureConnectionResponse getTemperatureConnection(com.example.grpc.temperatureSensor.TemperatureConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemperatureConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public java.util.Iterator<com.example.grpc.temperatureSensor.StreamTemperatureResponse> streamCurrentTemperature(
        com.example.grpc.temperatureSensor.StreamTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCurrentTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TemperatureSensorConnection.
   */
  public static final class TemperatureSensorConnectionFutureStub
      extends io.grpc.stub.AbstractFutureStub<TemperatureSensorConnectionFutureStub> {
    private TemperatureSensorConnectionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorConnectionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorConnectionFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.temperatureSensor.TemperatureConnectionResponse> getTemperatureConnection(
        com.example.grpc.temperatureSensor.TemperatureConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTemperatureConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TEMPERATURE_CONNECTION = 0;
  private static final int METHODID_STREAM_CURRENT_TEMPERATURE = 1;

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
        case METHODID_GET_TEMPERATURE_CONNECTION:
          serviceImpl.getTemperatureConnection((com.example.grpc.temperatureSensor.TemperatureConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.TemperatureConnectionResponse>) responseObserver);
          break;
        case METHODID_STREAM_CURRENT_TEMPERATURE:
          serviceImpl.streamCurrentTemperature((com.example.grpc.temperatureSensor.StreamTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.StreamTemperatureResponse>) responseObserver);
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
          getGetTemperatureConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.temperatureSensor.TemperatureConnectionRequest,
              com.example.grpc.temperatureSensor.TemperatureConnectionResponse>(
                service, METHODID_GET_TEMPERATURE_CONNECTION)))
        .addMethod(
          getStreamCurrentTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpc.temperatureSensor.StreamTemperatureRequest,
              com.example.grpc.temperatureSensor.StreamTemperatureResponse>(
                service, METHODID_STREAM_CURRENT_TEMPERATURE)))
        .build();
  }

  private static abstract class TemperatureSensorConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureSensorConnectionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.temperatureSensor.temperatureProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureSensorConnection");
    }
  }

  private static final class TemperatureSensorConnectionFileDescriptorSupplier
      extends TemperatureSensorConnectionBaseDescriptorSupplier {
    TemperatureSensorConnectionFileDescriptorSupplier() {}
  }

  private static final class TemperatureSensorConnectionMethodDescriptorSupplier
      extends TemperatureSensorConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TemperatureSensorConnectionMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TemperatureSensorConnectionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureSensorConnectionFileDescriptorSupplier())
              .addMethod(getGetTemperatureConnectionMethod())
              .addMethod(getStreamCurrentTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}

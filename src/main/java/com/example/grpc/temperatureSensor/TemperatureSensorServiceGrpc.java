package com.example.grpc.temperatureSensor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: temperatureSensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TemperatureSensorServiceGrpc {

  private TemperatureSensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.temperatureSensor.TemperatureSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.UnaryTemperatureRequest,
      com.example.grpc.temperatureSensor.UnaryTemperatureResponse> getGetCurrentTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentTemperature",
      requestType = com.example.grpc.temperatureSensor.UnaryTemperatureRequest.class,
      responseType = com.example.grpc.temperatureSensor.UnaryTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.UnaryTemperatureRequest,
      com.example.grpc.temperatureSensor.UnaryTemperatureResponse> getGetCurrentTemperatureMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.temperatureSensor.UnaryTemperatureRequest, com.example.grpc.temperatureSensor.UnaryTemperatureResponse> getGetCurrentTemperatureMethod;
    if ((getGetCurrentTemperatureMethod = TemperatureSensorServiceGrpc.getGetCurrentTemperatureMethod) == null) {
      synchronized (TemperatureSensorServiceGrpc.class) {
        if ((getGetCurrentTemperatureMethod = TemperatureSensorServiceGrpc.getGetCurrentTemperatureMethod) == null) {
          TemperatureSensorServiceGrpc.getGetCurrentTemperatureMethod = getGetCurrentTemperatureMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.temperatureSensor.UnaryTemperatureRequest, com.example.grpc.temperatureSensor.UnaryTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.UnaryTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.UnaryTemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureSensorServiceMethodDescriptorSupplier("getCurrentTemperature"))
              .build();
        }
      }
    }
    return getGetCurrentTemperatureMethod;
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
    if ((getStreamCurrentTemperatureMethod = TemperatureSensorServiceGrpc.getStreamCurrentTemperatureMethod) == null) {
      synchronized (TemperatureSensorServiceGrpc.class) {
        if ((getStreamCurrentTemperatureMethod = TemperatureSensorServiceGrpc.getStreamCurrentTemperatureMethod) == null) {
          TemperatureSensorServiceGrpc.getStreamCurrentTemperatureMethod = getStreamCurrentTemperatureMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.temperatureSensor.StreamTemperatureRequest, com.example.grpc.temperatureSensor.StreamTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.StreamTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.temperatureSensor.StreamTemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureSensorServiceMethodDescriptorSupplier("streamCurrentTemperature"))
              .build();
        }
      }
    }
    return getStreamCurrentTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceStub>() {
        @java.lang.Override
        public TemperatureSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorServiceStub(channel, callOptions);
        }
      };
    return TemperatureSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceBlockingStub>() {
        @java.lang.Override
        public TemperatureSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorServiceBlockingStub(channel, callOptions);
        }
      };
    return TemperatureSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureSensorServiceFutureStub>() {
        @java.lang.Override
        public TemperatureSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureSensorServiceFutureStub(channel, callOptions);
        }
      };
    return TemperatureSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void getCurrentTemperature(com.example.grpc.temperatureSensor.UnaryTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.UnaryTemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentTemperatureMethod(), responseObserver);
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
   * Base class for the server implementation of the service TemperatureSensorService.
   */
  public static abstract class TemperatureSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TemperatureSensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TemperatureSensorService.
   */
  public static final class TemperatureSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TemperatureSensorServiceStub> {
    private TemperatureSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void getCurrentTemperature(com.example.grpc.temperatureSensor.UnaryTemperatureRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.UnaryTemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request, responseObserver);
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
   * A stub to allow clients to do synchronous rpc calls to service TemperatureSensorService.
   */
  public static final class TemperatureSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TemperatureSensorServiceBlockingStub> {
    private TemperatureSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.example.grpc.temperatureSensor.UnaryTemperatureResponse getCurrentTemperature(com.example.grpc.temperatureSensor.UnaryTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentTemperatureMethod(), getCallOptions(), request);
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
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TemperatureSensorService.
   */
  public static final class TemperatureSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TemperatureSensorServiceFutureStub> {
    private TemperatureSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureSensorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.temperatureSensor.UnaryTemperatureResponse> getCurrentTemperature(
        com.example.grpc.temperatureSensor.UnaryTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_TEMPERATURE = 0;
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
        case METHODID_GET_CURRENT_TEMPERATURE:
          serviceImpl.getCurrentTemperature((com.example.grpc.temperatureSensor.UnaryTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.temperatureSensor.UnaryTemperatureResponse>) responseObserver);
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
          getGetCurrentTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.temperatureSensor.UnaryTemperatureRequest,
              com.example.grpc.temperatureSensor.UnaryTemperatureResponse>(
                service, METHODID_GET_CURRENT_TEMPERATURE)))
        .addMethod(
          getStreamCurrentTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpc.temperatureSensor.StreamTemperatureRequest,
              com.example.grpc.temperatureSensor.StreamTemperatureResponse>(
                service, METHODID_STREAM_CURRENT_TEMPERATURE)))
        .build();
  }

  private static abstract class TemperatureSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.temperatureSensor.temperatureProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureSensorService");
    }
  }

  private static final class TemperatureSensorServiceFileDescriptorSupplier
      extends TemperatureSensorServiceBaseDescriptorSupplier {
    TemperatureSensorServiceFileDescriptorSupplier() {}
  }

  private static final class TemperatureSensorServiceMethodDescriptorSupplier
      extends TemperatureSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TemperatureSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TemperatureSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureSensorServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentTemperatureMethod())
              .addMethod(getStreamCurrentTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}

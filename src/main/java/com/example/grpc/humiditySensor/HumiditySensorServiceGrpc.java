package com.example.grpc.humiditySensor;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: humiditySensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HumiditySensorServiceGrpc {

  private HumiditySensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.humiditySensor.HumiditySensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.UnaryHumidityRequest,
      com.example.grpc.humiditySensor.UnaryHumidityResponse> getGetCurrentHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentHumidity",
      requestType = com.example.grpc.humiditySensor.UnaryHumidityRequest.class,
      responseType = com.example.grpc.humiditySensor.UnaryHumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.UnaryHumidityRequest,
      com.example.grpc.humiditySensor.UnaryHumidityResponse> getGetCurrentHumidityMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.UnaryHumidityRequest, com.example.grpc.humiditySensor.UnaryHumidityResponse> getGetCurrentHumidityMethod;
    if ((getGetCurrentHumidityMethod = HumiditySensorServiceGrpc.getGetCurrentHumidityMethod) == null) {
      synchronized (HumiditySensorServiceGrpc.class) {
        if ((getGetCurrentHumidityMethod = HumiditySensorServiceGrpc.getGetCurrentHumidityMethod) == null) {
          HumiditySensorServiceGrpc.getGetCurrentHumidityMethod = getGetCurrentHumidityMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.humiditySensor.UnaryHumidityRequest, com.example.grpc.humiditySensor.UnaryHumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.humiditySensor.UnaryHumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.humiditySensor.UnaryHumidityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HumiditySensorServiceMethodDescriptorSupplier("getCurrentHumidity"))
              .build();
        }
      }
    }
    return getGetCurrentHumidityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.StreamHumidityRequest,
      com.example.grpc.humiditySensor.StreamHumidityResponse> getStreamCurrentHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamCurrentHumidity",
      requestType = com.example.grpc.humiditySensor.StreamHumidityRequest.class,
      responseType = com.example.grpc.humiditySensor.StreamHumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.StreamHumidityRequest,
      com.example.grpc.humiditySensor.StreamHumidityResponse> getStreamCurrentHumidityMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.humiditySensor.StreamHumidityRequest, com.example.grpc.humiditySensor.StreamHumidityResponse> getStreamCurrentHumidityMethod;
    if ((getStreamCurrentHumidityMethod = HumiditySensorServiceGrpc.getStreamCurrentHumidityMethod) == null) {
      synchronized (HumiditySensorServiceGrpc.class) {
        if ((getStreamCurrentHumidityMethod = HumiditySensorServiceGrpc.getStreamCurrentHumidityMethod) == null) {
          HumiditySensorServiceGrpc.getStreamCurrentHumidityMethod = getStreamCurrentHumidityMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.humiditySensor.StreamHumidityRequest, com.example.grpc.humiditySensor.StreamHumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamCurrentHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.humiditySensor.StreamHumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.humiditySensor.StreamHumidityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HumiditySensorServiceMethodDescriptorSupplier("streamCurrentHumidity"))
              .build();
        }
      }
    }
    return getStreamCurrentHumidityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HumiditySensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceStub>() {
        @java.lang.Override
        public HumiditySensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumiditySensorServiceStub(channel, callOptions);
        }
      };
    return HumiditySensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HumiditySensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceBlockingStub>() {
        @java.lang.Override
        public HumiditySensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumiditySensorServiceBlockingStub(channel, callOptions);
        }
      };
    return HumiditySensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HumiditySensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HumiditySensorServiceFutureStub>() {
        @java.lang.Override
        public HumiditySensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HumiditySensorServiceFutureStub(channel, callOptions);
        }
      };
    return HumiditySensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void getCurrentHumidity(com.example.grpc.humiditySensor.UnaryHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.UnaryHumidityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentHumidityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    default void streamCurrentHumidity(com.example.grpc.humiditySensor.StreamHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.StreamHumidityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCurrentHumidityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HumiditySensorService.
   */
  public static abstract class HumiditySensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HumiditySensorServiceGrpc.bindService(this);
    }

    public abstract void streamCurrentHumidity(StreamHumidityRequest request, StreamObserver<StreamHumidityResponse> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HumiditySensorService.
   */
  public static final class HumiditySensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HumiditySensorServiceStub> {
    private HumiditySensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumiditySensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumiditySensorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void getCurrentHumidity(com.example.grpc.humiditySensor.UnaryHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.UnaryHumidityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentHumidityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public void streamCurrentHumidity(com.example.grpc.humiditySensor.StreamHumidityRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.StreamHumidityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCurrentHumidityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HumiditySensorService.
   */
  public static final class HumiditySensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HumiditySensorServiceBlockingStub> {
    private HumiditySensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumiditySensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumiditySensorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.example.grpc.humiditySensor.UnaryHumidityResponse getCurrentHumidity(com.example.grpc.humiditySensor.UnaryHumidityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentHumidityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public java.util.Iterator<com.example.grpc.humiditySensor.StreamHumidityResponse> streamCurrentHumidity(
        com.example.grpc.humiditySensor.StreamHumidityRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCurrentHumidityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HumiditySensorService.
   */
  public static final class HumiditySensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HumiditySensorServiceFutureStub> {
    private HumiditySensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumiditySensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HumiditySensorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.humiditySensor.UnaryHumidityResponse> getCurrentHumidity(
        com.example.grpc.humiditySensor.UnaryHumidityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentHumidityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_HUMIDITY = 0;
  private static final int METHODID_STREAM_CURRENT_HUMIDITY = 1;

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
        case METHODID_GET_CURRENT_HUMIDITY:
          serviceImpl.getCurrentHumidity((com.example.grpc.humiditySensor.UnaryHumidityRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.UnaryHumidityResponse>) responseObserver);
          break;
        case METHODID_STREAM_CURRENT_HUMIDITY:
          serviceImpl.streamCurrentHumidity((com.example.grpc.humiditySensor.StreamHumidityRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.humiditySensor.StreamHumidityResponse>) responseObserver);
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
          getGetCurrentHumidityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.humiditySensor.UnaryHumidityRequest,
              com.example.grpc.humiditySensor.UnaryHumidityResponse>(
                service, METHODID_GET_CURRENT_HUMIDITY)))
        .addMethod(
          getStreamCurrentHumidityMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpc.humiditySensor.StreamHumidityRequest,
              com.example.grpc.humiditySensor.StreamHumidityResponse>(
                service, METHODID_STREAM_CURRENT_HUMIDITY)))
        .build();
  }

  private static abstract class HumiditySensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HumiditySensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.humiditySensor.humidityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HumiditySensorService");
    }
  }

  private static final class HumiditySensorServiceFileDescriptorSupplier
      extends HumiditySensorServiceBaseDescriptorSupplier {
    HumiditySensorServiceFileDescriptorSupplier() {}
  }

  private static final class HumiditySensorServiceMethodDescriptorSupplier
      extends HumiditySensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HumiditySensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HumiditySensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HumiditySensorServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentHumidityMethod())
              .addMethod(getStreamCurrentHumidityMethod())
              .build();
        }
      }
    }
    return result;
  }
}

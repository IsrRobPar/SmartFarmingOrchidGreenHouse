package com.example.grpc.fanStatus;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: fanStatus.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamingTemperatureFanStatusGrpc {

  private StreamingTemperatureFanStatusGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.fanStatus.StreamingTemperatureFanStatus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.fanStatus.StreamTemperatureToFan,
      com.example.grpc.fanStatus.StreamFanStatus> getStreamingTemperatureFanStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingTemperatureFanStatus",
      requestType = com.example.grpc.fanStatus.StreamTemperatureToFan.class,
      responseType = com.example.grpc.fanStatus.StreamFanStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.fanStatus.StreamTemperatureToFan,
      com.example.grpc.fanStatus.StreamFanStatus> getStreamingTemperatureFanStatusMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.fanStatus.StreamTemperatureToFan, com.example.grpc.fanStatus.StreamFanStatus> getStreamingTemperatureFanStatusMethod;
    if ((getStreamingTemperatureFanStatusMethod = StreamingTemperatureFanStatusGrpc.getStreamingTemperatureFanStatusMethod) == null) {
      synchronized (StreamingTemperatureFanStatusGrpc.class) {
        if ((getStreamingTemperatureFanStatusMethod = StreamingTemperatureFanStatusGrpc.getStreamingTemperatureFanStatusMethod) == null) {
          StreamingTemperatureFanStatusGrpc.getStreamingTemperatureFanStatusMethod = getStreamingTemperatureFanStatusMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.fanStatus.StreamTemperatureToFan, com.example.grpc.fanStatus.StreamFanStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingTemperatureFanStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.fanStatus.StreamTemperatureToFan.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.fanStatus.StreamFanStatus.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingTemperatureFanStatusMethodDescriptorSupplier("StreamingTemperatureFanStatus"))
              .build();
        }
      }
    }
    return getStreamingTemperatureFanStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamingTemperatureFanStatusStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusStub>() {
        @java.lang.Override
        public StreamingTemperatureFanStatusStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingTemperatureFanStatusStub(channel, callOptions);
        }
      };
    return StreamingTemperatureFanStatusStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamingTemperatureFanStatusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusBlockingStub>() {
        @java.lang.Override
        public StreamingTemperatureFanStatusBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingTemperatureFanStatusBlockingStub(channel, callOptions);
        }
      };
    return StreamingTemperatureFanStatusBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamingTemperatureFanStatusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingTemperatureFanStatusFutureStub>() {
        @java.lang.Override
        public StreamingTemperatureFanStatusFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingTemperatureFanStatusFutureStub(channel, callOptions);
        }
      };
    return StreamingTemperatureFanStatusFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Bidirectional streaming RPC
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.example.grpc.fanStatus.StreamTemperatureToFan> streamingTemperatureFanStatus(
        io.grpc.stub.StreamObserver<com.example.grpc.fanStatus.StreamFanStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingTemperatureFanStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamingTemperatureFanStatus.
   */
  public static abstract class StreamingTemperatureFanStatusImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StreamingTemperatureFanStatusGrpc.bindService(this);
    }

    public abstract StreamObserver<StreamTemperatureToFan> StreamingTemperatureFanStatus(StreamObserver<StreamFanStatus> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamingTemperatureFanStatus.
   */
  public static final class StreamingTemperatureFanStatusStub
      extends io.grpc.stub.AbstractAsyncStub<StreamingTemperatureFanStatusStub> {
    private StreamingTemperatureFanStatusStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingTemperatureFanStatusStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingTemperatureFanStatusStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.fanStatus.StreamTemperatureToFan> streamingTemperatureFanStatus(
        io.grpc.stub.StreamObserver<com.example.grpc.fanStatus.StreamFanStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingTemperatureFanStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamingTemperatureFanStatus.
   */
  public static final class StreamingTemperatureFanStatusBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamingTemperatureFanStatusBlockingStub> {
    private StreamingTemperatureFanStatusBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingTemperatureFanStatusBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingTemperatureFanStatusBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamingTemperatureFanStatus.
   */
  public static final class StreamingTemperatureFanStatusFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamingTemperatureFanStatusFutureStub> {
    private StreamingTemperatureFanStatusFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingTemperatureFanStatusFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingTemperatureFanStatusFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAMING_TEMPERATURE_FAN_STATUS = 0;

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
        case METHODID_STREAMING_TEMPERATURE_FAN_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingTemperatureFanStatus(
              (io.grpc.stub.StreamObserver<com.example.grpc.fanStatus.StreamFanStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStreamingTemperatureFanStatusMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.example.grpc.fanStatus.StreamTemperatureToFan,
              com.example.grpc.fanStatus.StreamFanStatus>(
                service, METHODID_STREAMING_TEMPERATURE_FAN_STATUS)))
        .build();
  }

  private static abstract class StreamingTemperatureFanStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamingTemperatureFanStatusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.fanStatus.fanStatusProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamingTemperatureFanStatus");
    }
  }

  private static final class StreamingTemperatureFanStatusFileDescriptorSupplier
      extends StreamingTemperatureFanStatusBaseDescriptorSupplier {
    StreamingTemperatureFanStatusFileDescriptorSupplier() {}
  }

  private static final class StreamingTemperatureFanStatusMethodDescriptorSupplier
      extends StreamingTemperatureFanStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamingTemperatureFanStatusMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StreamingTemperatureFanStatusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamingTemperatureFanStatusFileDescriptorSupplier())
              .addMethod(getStreamingTemperatureFanStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}

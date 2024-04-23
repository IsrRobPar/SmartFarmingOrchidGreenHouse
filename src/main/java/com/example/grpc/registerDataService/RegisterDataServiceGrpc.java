package com.example.grpc.registerDataService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: registerData.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegisterDataServiceGrpc {

  private RegisterDataServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.grpc.registerDataService.RegisterDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.registerDataService.SensorDataRequest,
      com.example.grpc.registerDataService.SensorDataResponse> getSendDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendData",
      requestType = com.example.grpc.registerDataService.SensorDataRequest.class,
      responseType = com.example.grpc.registerDataService.SensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.registerDataService.SensorDataRequest,
      com.example.grpc.registerDataService.SensorDataResponse> getSendDataMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.registerDataService.SensorDataRequest, com.example.grpc.registerDataService.SensorDataResponse> getSendDataMethod;
    if ((getSendDataMethod = RegisterDataServiceGrpc.getSendDataMethod) == null) {
      synchronized (RegisterDataServiceGrpc.class) {
        if ((getSendDataMethod = RegisterDataServiceGrpc.getSendDataMethod) == null) {
          RegisterDataServiceGrpc.getSendDataMethod = getSendDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.registerDataService.SensorDataRequest, com.example.grpc.registerDataService.SensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.registerDataService.SensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.registerDataService.SensorDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterDataServiceMethodDescriptorSupplier("sendData"))
              .build();
        }
      }
    }
    return getSendDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceStub>() {
        @java.lang.Override
        public RegisterDataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterDataServiceStub(channel, callOptions);
        }
      };
    return RegisterDataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceBlockingStub>() {
        @java.lang.Override
        public RegisterDataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterDataServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterDataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterDataServiceFutureStub>() {
        @java.lang.Override
        public RegisterDataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterDataServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpc.registerDataService.SensorDataRequest> sendData(
        io.grpc.stub.StreamObserver<com.example.grpc.registerDataService.SensorDataResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RegisterDataService.
   */
  public static abstract class RegisterDataServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RegisterDataServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RegisterDataService.
   */
  public static final class RegisterDataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegisterDataServiceStub> {
    private RegisterDataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterDataServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.registerDataService.SensorDataRequest> sendData(
        io.grpc.stub.StreamObserver<com.example.grpc.registerDataService.SensorDataResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RegisterDataService.
   */
  public static final class RegisterDataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegisterDataServiceBlockingStub> {
    private RegisterDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterDataServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegisterDataService.
   */
  public static final class RegisterDataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegisterDataServiceFutureStub> {
    private RegisterDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterDataServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_DATA = 0;

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
        case METHODID_SEND_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendData(
              (io.grpc.stub.StreamObserver<com.example.grpc.registerDataService.SensorDataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendDataMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.example.grpc.registerDataService.SensorDataRequest,
              com.example.grpc.registerDataService.SensorDataResponse>(
                service, METHODID_SEND_DATA)))
        .build();
  }

  private static abstract class RegisterDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.registerDataService.registerDataServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterDataService");
    }
  }

  private static final class RegisterDataServiceFileDescriptorSupplier
      extends RegisterDataServiceBaseDescriptorSupplier {
    RegisterDataServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterDataServiceMethodDescriptorSupplier
      extends RegisterDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegisterDataServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegisterDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterDataServiceFileDescriptorSupplier())
              .addMethod(getSendDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}

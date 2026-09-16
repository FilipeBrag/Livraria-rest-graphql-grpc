package com.livraria.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: livraria.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LivrariaServiceGrpc {

  private LivrariaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "livraria.LivrariaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.livraria.grpc.proto.BuscarLivroRequest,
      com.livraria.grpc.proto.LivroResponse> getBuscarLivroMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BuscarLivro",
      requestType = com.livraria.grpc.proto.BuscarLivroRequest.class,
      responseType = com.livraria.grpc.proto.LivroResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.livraria.grpc.proto.BuscarLivroRequest,
      com.livraria.grpc.proto.LivroResponse> getBuscarLivroMethod() {
    io.grpc.MethodDescriptor<com.livraria.grpc.proto.BuscarLivroRequest, com.livraria.grpc.proto.LivroResponse> getBuscarLivroMethod;
    if ((getBuscarLivroMethod = LivrariaServiceGrpc.getBuscarLivroMethod) == null) {
      synchronized (LivrariaServiceGrpc.class) {
        if ((getBuscarLivroMethod = LivrariaServiceGrpc.getBuscarLivroMethod) == null) {
          LivrariaServiceGrpc.getBuscarLivroMethod = getBuscarLivroMethod =
              io.grpc.MethodDescriptor.<com.livraria.grpc.proto.BuscarLivroRequest, com.livraria.grpc.proto.LivroResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BuscarLivro"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.BuscarLivroRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.LivroResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivrariaServiceMethodDescriptorSupplier("BuscarLivro"))
              .build();
        }
      }
    }
    return getBuscarLivroMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.livraria.grpc.proto.FiltroRequest,
      com.livraria.grpc.proto.LivroResponse> getStreamCatalogoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCatalogo",
      requestType = com.livraria.grpc.proto.FiltroRequest.class,
      responseType = com.livraria.grpc.proto.LivroResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.livraria.grpc.proto.FiltroRequest,
      com.livraria.grpc.proto.LivroResponse> getStreamCatalogoMethod() {
    io.grpc.MethodDescriptor<com.livraria.grpc.proto.FiltroRequest, com.livraria.grpc.proto.LivroResponse> getStreamCatalogoMethod;
    if ((getStreamCatalogoMethod = LivrariaServiceGrpc.getStreamCatalogoMethod) == null) {
      synchronized (LivrariaServiceGrpc.class) {
        if ((getStreamCatalogoMethod = LivrariaServiceGrpc.getStreamCatalogoMethod) == null) {
          LivrariaServiceGrpc.getStreamCatalogoMethod = getStreamCatalogoMethod =
              io.grpc.MethodDescriptor.<com.livraria.grpc.proto.FiltroRequest, com.livraria.grpc.proto.LivroResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCatalogo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.FiltroRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.LivroResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LivrariaServiceMethodDescriptorSupplier("StreamCatalogo"))
              .build();
        }
      }
    }
    return getStreamCatalogoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.livraria.grpc.proto.AtualizarPrecoRequest,
      com.livraria.grpc.proto.ResumoAtualizacao> getAtualizarPrecosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AtualizarPrecos",
      requestType = com.livraria.grpc.proto.AtualizarPrecoRequest.class,
      responseType = com.livraria.grpc.proto.ResumoAtualizacao.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.livraria.grpc.proto.AtualizarPrecoRequest,
      com.livraria.grpc.proto.ResumoAtualizacao> getAtualizarPrecosMethod() {
    io.grpc.MethodDescriptor<com.livraria.grpc.proto.AtualizarPrecoRequest, com.livraria.grpc.proto.ResumoAtualizacao> getAtualizarPrecosMethod;
    if ((getAtualizarPrecosMethod = LivrariaServiceGrpc.getAtualizarPrecosMethod) == null) {
      synchronized (LivrariaServiceGrpc.class) {
        if ((getAtualizarPrecosMethod = LivrariaServiceGrpc.getAtualizarPrecosMethod) == null) {
          LivrariaServiceGrpc.getAtualizarPrecosMethod = getAtualizarPrecosMethod =
              io.grpc.MethodDescriptor.<com.livraria.grpc.proto.AtualizarPrecoRequest, com.livraria.grpc.proto.ResumoAtualizacao>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AtualizarPrecos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.AtualizarPrecoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.ResumoAtualizacao.getDefaultInstance()))
              .setSchemaDescriptor(new LivrariaServiceMethodDescriptorSupplier("AtualizarPrecos"))
              .build();
        }
      }
    }
    return getAtualizarPrecosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.livraria.grpc.proto.MonitorarRequest,
      com.livraria.grpc.proto.PrecoUpdate> getMonitorarPrecosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorarPrecos",
      requestType = com.livraria.grpc.proto.MonitorarRequest.class,
      responseType = com.livraria.grpc.proto.PrecoUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.livraria.grpc.proto.MonitorarRequest,
      com.livraria.grpc.proto.PrecoUpdate> getMonitorarPrecosMethod() {
    io.grpc.MethodDescriptor<com.livraria.grpc.proto.MonitorarRequest, com.livraria.grpc.proto.PrecoUpdate> getMonitorarPrecosMethod;
    if ((getMonitorarPrecosMethod = LivrariaServiceGrpc.getMonitorarPrecosMethod) == null) {
      synchronized (LivrariaServiceGrpc.class) {
        if ((getMonitorarPrecosMethod = LivrariaServiceGrpc.getMonitorarPrecosMethod) == null) {
          LivrariaServiceGrpc.getMonitorarPrecosMethod = getMonitorarPrecosMethod =
              io.grpc.MethodDescriptor.<com.livraria.grpc.proto.MonitorarRequest, com.livraria.grpc.proto.PrecoUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorarPrecos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.MonitorarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.livraria.grpc.proto.PrecoUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new LivrariaServiceMethodDescriptorSupplier("MonitorarPrecos"))
              .build();
        }
      }
    }
    return getMonitorarPrecosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LivrariaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceStub>() {
        @java.lang.Override
        public LivrariaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivrariaServiceStub(channel, callOptions);
        }
      };
    return LivrariaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LivrariaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceBlockingStub>() {
        @java.lang.Override
        public LivrariaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivrariaServiceBlockingStub(channel, callOptions);
        }
      };
    return LivrariaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LivrariaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivrariaServiceFutureStub>() {
        @java.lang.Override
        public LivrariaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivrariaServiceFutureStub(channel, callOptions);
        }
      };
    return LivrariaServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 1. UNARIO — request/response classico (equivalente ao REST)
     * </pre>
     */
    default void buscarLivro(com.livraria.grpc.proto.BuscarLivroRequest request,
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBuscarLivroMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING — servidor envia multiplos livros um por um
     * </pre>
     */
    default void streamCatalogo(com.livraria.grpc.proto.FiltroRequest request,
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCatalogoMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3. CLIENT STREAMING — cliente envia lote de atualizacoes, servidor responde uma vez
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.livraria.grpc.proto.AtualizarPrecoRequest> atualizarPrecos(
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.ResumoAtualizacao> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAtualizarPrecosMethod(), responseObserver);
    }

    /**
     * <pre>
     * 4. BIDIRECTIONAL STREAMING — ambos os lados streamam simultaneamente
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.livraria.grpc.proto.MonitorarRequest> monitorarPrecos(
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.PrecoUpdate> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorarPrecosMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LivrariaService.
   */
  public static abstract class LivrariaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LivrariaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LivrariaService.
   */
  public static final class LivrariaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LivrariaServiceStub> {
    private LivrariaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivrariaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivrariaServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARIO — request/response classico (equivalente ao REST)
     * </pre>
     */
    public void buscarLivro(com.livraria.grpc.proto.BuscarLivroRequest request,
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBuscarLivroMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING — servidor envia multiplos livros um por um
     * </pre>
     */
    public void streamCatalogo(com.livraria.grpc.proto.FiltroRequest request,
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCatalogoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 3. CLIENT STREAMING — cliente envia lote de atualizacoes, servidor responde uma vez
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.livraria.grpc.proto.AtualizarPrecoRequest> atualizarPrecos(
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.ResumoAtualizacao> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAtualizarPrecosMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 4. BIDIRECTIONAL STREAMING — ambos os lados streamam simultaneamente
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.livraria.grpc.proto.MonitorarRequest> monitorarPrecos(
        io.grpc.stub.StreamObserver<com.livraria.grpc.proto.PrecoUpdate> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorarPrecosMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LivrariaService.
   */
  public static final class LivrariaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LivrariaServiceBlockingStub> {
    private LivrariaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivrariaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivrariaServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARIO — request/response classico (equivalente ao REST)
     * </pre>
     */
    public com.livraria.grpc.proto.LivroResponse buscarLivro(com.livraria.grpc.proto.BuscarLivroRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBuscarLivroMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 2. SERVER STREAMING — servidor envia multiplos livros um por um
     * </pre>
     */
    public java.util.Iterator<com.livraria.grpc.proto.LivroResponse> streamCatalogo(
        com.livraria.grpc.proto.FiltroRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCatalogoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LivrariaService.
   */
  public static final class LivrariaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LivrariaServiceFutureStub> {
    private LivrariaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivrariaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivrariaServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. UNARIO — request/response classico (equivalente ao REST)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.livraria.grpc.proto.LivroResponse> buscarLivro(
        com.livraria.grpc.proto.BuscarLivroRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBuscarLivroMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BUSCAR_LIVRO = 0;
  private static final int METHODID_STREAM_CATALOGO = 1;
  private static final int METHODID_ATUALIZAR_PRECOS = 2;
  private static final int METHODID_MONITORAR_PRECOS = 3;

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
        case METHODID_BUSCAR_LIVRO:
          serviceImpl.buscarLivro((com.livraria.grpc.proto.BuscarLivroRequest) request,
              (io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse>) responseObserver);
          break;
        case METHODID_STREAM_CATALOGO:
          serviceImpl.streamCatalogo((com.livraria.grpc.proto.FiltroRequest) request,
              (io.grpc.stub.StreamObserver<com.livraria.grpc.proto.LivroResponse>) responseObserver);
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
        case METHODID_ATUALIZAR_PRECOS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.atualizarPrecos(
              (io.grpc.stub.StreamObserver<com.livraria.grpc.proto.ResumoAtualizacao>) responseObserver);
        case METHODID_MONITORAR_PRECOS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorarPrecos(
              (io.grpc.stub.StreamObserver<com.livraria.grpc.proto.PrecoUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getBuscarLivroMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.livraria.grpc.proto.BuscarLivroRequest,
              com.livraria.grpc.proto.LivroResponse>(
                service, METHODID_BUSCAR_LIVRO)))
        .addMethod(
          getStreamCatalogoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.livraria.grpc.proto.FiltroRequest,
              com.livraria.grpc.proto.LivroResponse>(
                service, METHODID_STREAM_CATALOGO)))
        .addMethod(
          getAtualizarPrecosMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.livraria.grpc.proto.AtualizarPrecoRequest,
              com.livraria.grpc.proto.ResumoAtualizacao>(
                service, METHODID_ATUALIZAR_PRECOS)))
        .addMethod(
          getMonitorarPrecosMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.livraria.grpc.proto.MonitorarRequest,
              com.livraria.grpc.proto.PrecoUpdate>(
                service, METHODID_MONITORAR_PRECOS)))
        .build();
  }

  private static abstract class LivrariaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LivrariaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.livraria.grpc.proto.LivrariaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LivrariaService");
    }
  }

  private static final class LivrariaServiceFileDescriptorSupplier
      extends LivrariaServiceBaseDescriptorSupplier {
    LivrariaServiceFileDescriptorSupplier() {}
  }

  private static final class LivrariaServiceMethodDescriptorSupplier
      extends LivrariaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LivrariaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LivrariaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LivrariaServiceFileDescriptorSupplier())
              .addMethod(getBuscarLivroMethod())
              .addMethod(getStreamCatalogoMethod())
              .addMethod(getAtualizarPrecosMethod())
              .addMethod(getMonitorarPrecosMethod())
              .build();
        }
      }
    }
    return result;
  }
}

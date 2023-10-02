package mlh.pavan.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: stackoverflow.proto")
public final class StackOverflowGrpc {

  private StackOverflowGrpc() {}

  public static final String SERVICE_NAME = "StackOverflow";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GreetRequest,
      mlh.pavan.grpc.Stackoverflow.GreetResponse> getGreetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Greet",
      requestType = mlh.pavan.grpc.Stackoverflow.GreetRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.GreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GreetRequest,
      mlh.pavan.grpc.Stackoverflow.GreetResponse> getGreetMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GreetRequest, mlh.pavan.grpc.Stackoverflow.GreetResponse> getGreetMethod;
    if ((getGreetMethod = StackOverflowGrpc.getGreetMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getGreetMethod = StackOverflowGrpc.getGreetMethod) == null) {
          StackOverflowGrpc.getGreetMethod = getGreetMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.GreetRequest, mlh.pavan.grpc.Stackoverflow.GreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "Greet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GreetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GreetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("Greet"))
                  .build();
          }
        }
     }
     return getGreetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.SignUpRequest,
      mlh.pavan.grpc.Stackoverflow.SignUpResponse> getSignUpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignUp",
      requestType = mlh.pavan.grpc.Stackoverflow.SignUpRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.SignUpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.SignUpRequest,
      mlh.pavan.grpc.Stackoverflow.SignUpResponse> getSignUpMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.SignUpRequest, mlh.pavan.grpc.Stackoverflow.SignUpResponse> getSignUpMethod;
    if ((getSignUpMethod = StackOverflowGrpc.getSignUpMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getSignUpMethod = StackOverflowGrpc.getSignUpMethod) == null) {
          StackOverflowGrpc.getSignUpMethod = getSignUpMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.SignUpRequest, mlh.pavan.grpc.Stackoverflow.SignUpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "SignUp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.SignUpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.SignUpResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("SignUp"))
                  .build();
          }
        }
     }
     return getSignUpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LoginRequest,
      mlh.pavan.grpc.Stackoverflow.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = mlh.pavan.grpc.Stackoverflow.LoginRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LoginRequest,
      mlh.pavan.grpc.Stackoverflow.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LoginRequest, mlh.pavan.grpc.Stackoverflow.LoginResponse> getLoginMethod;
    if ((getLoginMethod = StackOverflowGrpc.getLoginMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getLoginMethod = StackOverflowGrpc.getLoginMethod) == null) {
          StackOverflowGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.LoginRequest, mlh.pavan.grpc.Stackoverflow.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetTokenRequest,
      mlh.pavan.grpc.Stackoverflow.GetTokenResponse> getGetTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetToken",
      requestType = mlh.pavan.grpc.Stackoverflow.GetTokenRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.GetTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetTokenRequest,
      mlh.pavan.grpc.Stackoverflow.GetTokenResponse> getGetTokenMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetTokenRequest, mlh.pavan.grpc.Stackoverflow.GetTokenResponse> getGetTokenMethod;
    if ((getGetTokenMethod = StackOverflowGrpc.getGetTokenMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getGetTokenMethod = StackOverflowGrpc.getGetTokenMethod) == null) {
          StackOverflowGrpc.getGetTokenMethod = getGetTokenMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.GetTokenRequest, mlh.pavan.grpc.Stackoverflow.GetTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "GetToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GetTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GetTokenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("GetToken"))
                  .build();
          }
        }
     }
     return getGetTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.CheckTokenRequest,
      mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> getCheckTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckToken",
      requestType = mlh.pavan.grpc.Stackoverflow.CheckTokenRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.CheckTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.CheckTokenRequest,
      mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> getCheckTokenMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.CheckTokenRequest, mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> getCheckTokenMethod;
    if ((getCheckTokenMethod = StackOverflowGrpc.getCheckTokenMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getCheckTokenMethod = StackOverflowGrpc.getCheckTokenMethod) == null) {
          StackOverflowGrpc.getCheckTokenMethod = getCheckTokenMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.CheckTokenRequest, mlh.pavan.grpc.Stackoverflow.CheckTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "CheckToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.CheckTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.CheckTokenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("CheckToken"))
                  .build();
          }
        }
     }
     return getCheckTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LogoutRequest,
      mlh.pavan.grpc.Stackoverflow.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Logout",
      requestType = mlh.pavan.grpc.Stackoverflow.LogoutRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LogoutRequest,
      mlh.pavan.grpc.Stackoverflow.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.LogoutRequest, mlh.pavan.grpc.Stackoverflow.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = StackOverflowGrpc.getLogoutMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getLogoutMethod = StackOverflowGrpc.getLogoutMethod) == null) {
          StackOverflowGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.LogoutRequest, mlh.pavan.grpc.Stackoverflow.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("Logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest,
      mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> getChangePasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangePassword",
      requestType = mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest,
      mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> getChangePasswordMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest, mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> getChangePasswordMethod;
    if ((getChangePasswordMethod = StackOverflowGrpc.getChangePasswordMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getChangePasswordMethod = StackOverflowGrpc.getChangePasswordMethod) == null) {
          StackOverflowGrpc.getChangePasswordMethod = getChangePasswordMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest, mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "ChangePassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("ChangePassword"))
                  .build();
          }
        }
     }
     return getChangePasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> getChangeUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeUserName",
      requestType = mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> getChangeUserNameMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest, mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> getChangeUserNameMethod;
    if ((getChangeUserNameMethod = StackOverflowGrpc.getChangeUserNameMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getChangeUserNameMethod = StackOverflowGrpc.getChangeUserNameMethod) == null) {
          StackOverflowGrpc.getChangeUserNameMethod = getChangeUserNameMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest, mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "ChangeUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("ChangeUserName"))
                  .build();
          }
        }
     }
     return getChangeUserNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> getChangeDescriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeDescription",
      requestType = mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> getChangeDescriptionMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest, mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> getChangeDescriptionMethod;
    if ((getChangeDescriptionMethod = StackOverflowGrpc.getChangeDescriptionMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getChangeDescriptionMethod = StackOverflowGrpc.getChangeDescriptionMethod) == null) {
          StackOverflowGrpc.getChangeDescriptionMethod = getChangeDescriptionMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest, mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "ChangeDescription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("ChangeDescription"))
                  .build();
          }
        }
     }
     return getChangeDescriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> getChangeSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeSkill",
      requestType = mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> getChangeSkillMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest, mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> getChangeSkillMethod;
    if ((getChangeSkillMethod = StackOverflowGrpc.getChangeSkillMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getChangeSkillMethod = StackOverflowGrpc.getChangeSkillMethod) == null) {
          StackOverflowGrpc.getChangeSkillMethod = getChangeSkillMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest, mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "ChangeSkill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("ChangeSkill"))
                  .build();
          }
        }
     }
     return getChangeSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.AddSkillRequest,
      mlh.pavan.grpc.Stackoverflow.AddSkillResponse> getAddSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSkill",
      requestType = mlh.pavan.grpc.Stackoverflow.AddSkillRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.AddSkillResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.AddSkillRequest,
      mlh.pavan.grpc.Stackoverflow.AddSkillResponse> getAddSkillMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.AddSkillRequest, mlh.pavan.grpc.Stackoverflow.AddSkillResponse> getAddSkillMethod;
    if ((getAddSkillMethod = StackOverflowGrpc.getAddSkillMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getAddSkillMethod = StackOverflowGrpc.getAddSkillMethod) == null) {
          StackOverflowGrpc.getAddSkillMethod = getAddSkillMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.AddSkillRequest, mlh.pavan.grpc.Stackoverflow.AddSkillResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "AddSkill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.AddSkillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.AddSkillResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("AddSkill"))
                  .build();
          }
        }
     }
     return getAddSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest,
      mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> getDeleteSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSkill",
      requestType = mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest,
      mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> getDeleteSkillMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest, mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> getDeleteSkillMethod;
    if ((getDeleteSkillMethod = StackOverflowGrpc.getDeleteSkillMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getDeleteSkillMethod = StackOverflowGrpc.getDeleteSkillMethod) == null) {
          StackOverflowGrpc.getDeleteSkillMethod = getDeleteSkillMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest, mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "DeleteSkill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("DeleteSkill"))
                  .build();
          }
        }
     }
     return getDeleteSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteUserRequest,
      mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = mlh.pavan.grpc.Stackoverflow.DeleteUserRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteUserRequest,
      mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.DeleteUserRequest, mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = StackOverflowGrpc.getDeleteUserMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getDeleteUserMethod = StackOverflowGrpc.getDeleteUserMethod) == null) {
          StackOverflowGrpc.getDeleteUserMethod = getDeleteUserMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.DeleteUserRequest, mlh.pavan.grpc.Stackoverflow.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.DeleteUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("DeleteUser"))
                  .build();
          }
        }
     }
     return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest,
      mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> getUpdateRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRating",
      requestType = mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest,
      mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> getUpdateRatingMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest, mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> getUpdateRatingMethod;
    if ((getUpdateRatingMethod = StackOverflowGrpc.getUpdateRatingMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getUpdateRatingMethod = StackOverflowGrpc.getUpdateRatingMethod) == null) {
          StackOverflowGrpc.getUpdateRatingMethod = getUpdateRatingMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest, mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "UpdateRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("UpdateRating"))
                  .build();
          }
        }
     }
     return getUpdateRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> getChangeUserStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeUserStatus",
      requestType = mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest,
      mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> getChangeUserStatusMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest, mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> getChangeUserStatusMethod;
    if ((getChangeUserStatusMethod = StackOverflowGrpc.getChangeUserStatusMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getChangeUserStatusMethod = StackOverflowGrpc.getChangeUserStatusMethod) == null) {
          StackOverflowGrpc.getChangeUserStatusMethod = getChangeUserStatusMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest, mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "ChangeUserStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("ChangeUserStatus"))
                  .build();
          }
        }
     }
     return getChangeUserStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest,
      mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> getGetUserDetailsByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserDetailsById",
      requestType = mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest.class,
      responseType = mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest,
      mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> getGetUserDetailsByIdMethod() {
    io.grpc.MethodDescriptor<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest, mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> getGetUserDetailsByIdMethod;
    if ((getGetUserDetailsByIdMethod = StackOverflowGrpc.getGetUserDetailsByIdMethod) == null) {
      synchronized (StackOverflowGrpc.class) {
        if ((getGetUserDetailsByIdMethod = StackOverflowGrpc.getGetUserDetailsByIdMethod) == null) {
          StackOverflowGrpc.getGetUserDetailsByIdMethod = getGetUserDetailsByIdMethod = 
              io.grpc.MethodDescriptor.<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest, mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StackOverflow", "GetUserDetailsById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StackOverflowMethodDescriptorSupplier("GetUserDetailsById"))
                  .build();
          }
        }
     }
     return getGetUserDetailsByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StackOverflowStub newStub(io.grpc.Channel channel) {
    return new StackOverflowStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StackOverflowBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StackOverflowBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StackOverflowFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StackOverflowFutureStub(channel);
  }

  /**
   */
  public static abstract class StackOverflowImplBase implements io.grpc.BindableService {

    /**
     */
    public void greet(mlh.pavan.grpc.Stackoverflow.GreetRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GreetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetMethod(), responseObserver);
    }

    /**
     */
    public void signUp(mlh.pavan.grpc.Stackoverflow.SignUpRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.SignUpResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpMethod(), responseObserver);
    }

    /**
     */
    public void login(mlh.pavan.grpc.Stackoverflow.LoginRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getToken(mlh.pavan.grpc.Stackoverflow.GetTokenRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetTokenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTokenMethod(), responseObserver);
    }

    /**
     */
    public void checkToken(mlh.pavan.grpc.Stackoverflow.CheckTokenRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckTokenMethod(), responseObserver);
    }

    /**
     */
    public void logout(mlh.pavan.grpc.Stackoverflow.LogoutRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    public void changePassword(mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangePasswordMethod(), responseObserver);
    }

    /**
     */
    public void changeUserName(mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeUserNameMethod(), responseObserver);
    }

    /**
     */
    public void changeDescription(mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeDescriptionMethod(), responseObserver);
    }

    /**
     */
    public void changeSkill(mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeSkillMethod(), responseObserver);
    }

    /**
     */
    public void addSkill(mlh.pavan.grpc.Stackoverflow.AddSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.AddSkillResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddSkillMethod(), responseObserver);
    }

    /**
     */
    public void deleteSkill(mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSkillMethod(), responseObserver);
    }

    /**
     */
    public void deleteUser(mlh.pavan.grpc.Stackoverflow.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     */
    public void updateRating(mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRatingMethod(), responseObserver);
    }

    /**
     */
    public void changeUserStatus(mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeUserStatusMethod(), responseObserver);
    }

    /**
     */
    public void getUserDetailsById(mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserDetailsByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGreetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.GreetRequest,
                mlh.pavan.grpc.Stackoverflow.GreetResponse>(
                  this, METHODID_GREET)))
          .addMethod(
            getSignUpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.SignUpRequest,
                mlh.pavan.grpc.Stackoverflow.SignUpResponse>(
                  this, METHODID_SIGN_UP)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.LoginRequest,
                mlh.pavan.grpc.Stackoverflow.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getGetTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.GetTokenRequest,
                mlh.pavan.grpc.Stackoverflow.GetTokenResponse>(
                  this, METHODID_GET_TOKEN)))
          .addMethod(
            getCheckTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.CheckTokenRequest,
                mlh.pavan.grpc.Stackoverflow.CheckTokenResponse>(
                  this, METHODID_CHECK_TOKEN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.LogoutRequest,
                mlh.pavan.grpc.Stackoverflow.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getChangePasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest,
                mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse>(
                  this, METHODID_CHANGE_PASSWORD)))
          .addMethod(
            getChangeUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest,
                mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse>(
                  this, METHODID_CHANGE_USER_NAME)))
          .addMethod(
            getChangeDescriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest,
                mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse>(
                  this, METHODID_CHANGE_DESCRIPTION)))
          .addMethod(
            getChangeSkillMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest,
                mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse>(
                  this, METHODID_CHANGE_SKILL)))
          .addMethod(
            getAddSkillMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.AddSkillRequest,
                mlh.pavan.grpc.Stackoverflow.AddSkillResponse>(
                  this, METHODID_ADD_SKILL)))
          .addMethod(
            getDeleteSkillMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest,
                mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse>(
                  this, METHODID_DELETE_SKILL)))
          .addMethod(
            getDeleteUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.DeleteUserRequest,
                mlh.pavan.grpc.Stackoverflow.DeleteUserResponse>(
                  this, METHODID_DELETE_USER)))
          .addMethod(
            getUpdateRatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest,
                mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse>(
                  this, METHODID_UPDATE_RATING)))
          .addMethod(
            getChangeUserStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest,
                mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse>(
                  this, METHODID_CHANGE_USER_STATUS)))
          .addMethod(
            getGetUserDetailsByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest,
                mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse>(
                  this, METHODID_GET_USER_DETAILS_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class StackOverflowStub extends io.grpc.stub.AbstractStub<StackOverflowStub> {
    private StackOverflowStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StackOverflowStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StackOverflowStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StackOverflowStub(channel, callOptions);
    }

    /**
     */
    public void greet(mlh.pavan.grpc.Stackoverflow.GreetRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GreetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signUp(mlh.pavan.grpc.Stackoverflow.SignUpRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.SignUpResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(mlh.pavan.grpc.Stackoverflow.LoginRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getToken(mlh.pavan.grpc.Stackoverflow.GetTokenRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetTokenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkToken(mlh.pavan.grpc.Stackoverflow.CheckTokenRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(mlh.pavan.grpc.Stackoverflow.LogoutRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changePassword(mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangePasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeUserName(mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeUserNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeDescription(mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeDescriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeSkill(mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeSkillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addSkill(mlh.pavan.grpc.Stackoverflow.AddSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.AddSkillResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddSkillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSkill(mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSkillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(mlh.pavan.grpc.Stackoverflow.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRating(mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeUserStatus(mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeUserStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserDetailsById(mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest request,
        io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserDetailsByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StackOverflowBlockingStub extends io.grpc.stub.AbstractStub<StackOverflowBlockingStub> {
    private StackOverflowBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StackOverflowBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StackOverflowBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StackOverflowBlockingStub(channel, callOptions);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.GreetResponse greet(mlh.pavan.grpc.Stackoverflow.GreetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGreetMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.SignUpResponse signUp(mlh.pavan.grpc.Stackoverflow.SignUpRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignUpMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.LoginResponse login(mlh.pavan.grpc.Stackoverflow.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.GetTokenResponse getToken(mlh.pavan.grpc.Stackoverflow.GetTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.CheckTokenResponse checkToken(mlh.pavan.grpc.Stackoverflow.CheckTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.LogoutResponse logout(mlh.pavan.grpc.Stackoverflow.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse changePassword(mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangePasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse changeUserName(mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeUserNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse changeDescription(mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeDescriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse changeSkill(mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeSkillMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.AddSkillResponse addSkill(mlh.pavan.grpc.Stackoverflow.AddSkillRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddSkillMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse deleteSkill(mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSkillMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.DeleteUserResponse deleteUser(mlh.pavan.grpc.Stackoverflow.DeleteUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse updateRating(mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse changeUserStatus(mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeUserStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse getUserDetailsById(mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserDetailsByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StackOverflowFutureStub extends io.grpc.stub.AbstractStub<StackOverflowFutureStub> {
    private StackOverflowFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StackOverflowFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StackOverflowFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StackOverflowFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.GreetResponse> greet(
        mlh.pavan.grpc.Stackoverflow.GreetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.SignUpResponse> signUp(
        mlh.pavan.grpc.Stackoverflow.SignUpRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.LoginResponse> login(
        mlh.pavan.grpc.Stackoverflow.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.GetTokenResponse> getToken(
        mlh.pavan.grpc.Stackoverflow.GetTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> checkToken(
        mlh.pavan.grpc.Stackoverflow.CheckTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.LogoutResponse> logout(
        mlh.pavan.grpc.Stackoverflow.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse> changePassword(
        mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangePasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse> changeUserName(
        mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeUserNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse> changeDescription(
        mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeDescriptionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse> changeSkill(
        mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeSkillMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.AddSkillResponse> addSkill(
        mlh.pavan.grpc.Stackoverflow.AddSkillRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddSkillMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse> deleteSkill(
        mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSkillMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.DeleteUserResponse> deleteUser(
        mlh.pavan.grpc.Stackoverflow.DeleteUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse> updateRating(
        mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse> changeUserStatus(
        mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeUserStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse> getUserDetailsById(
        mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserDetailsByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GREET = 0;
  private static final int METHODID_SIGN_UP = 1;
  private static final int METHODID_LOGIN = 2;
  private static final int METHODID_GET_TOKEN = 3;
  private static final int METHODID_CHECK_TOKEN = 4;
  private static final int METHODID_LOGOUT = 5;
  private static final int METHODID_CHANGE_PASSWORD = 6;
  private static final int METHODID_CHANGE_USER_NAME = 7;
  private static final int METHODID_CHANGE_DESCRIPTION = 8;
  private static final int METHODID_CHANGE_SKILL = 9;
  private static final int METHODID_ADD_SKILL = 10;
  private static final int METHODID_DELETE_SKILL = 11;
  private static final int METHODID_DELETE_USER = 12;
  private static final int METHODID_UPDATE_RATING = 13;
  private static final int METHODID_CHANGE_USER_STATUS = 14;
  private static final int METHODID_GET_USER_DETAILS_BY_ID = 15;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StackOverflowImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StackOverflowImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GREET:
          serviceImpl.greet((mlh.pavan.grpc.Stackoverflow.GreetRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GreetResponse>) responseObserver);
          break;
        case METHODID_SIGN_UP:
          serviceImpl.signUp((mlh.pavan.grpc.Stackoverflow.SignUpRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.SignUpResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((mlh.pavan.grpc.Stackoverflow.LoginRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LoginResponse>) responseObserver);
          break;
        case METHODID_GET_TOKEN:
          serviceImpl.getToken((mlh.pavan.grpc.Stackoverflow.GetTokenRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetTokenResponse>) responseObserver);
          break;
        case METHODID_CHECK_TOKEN:
          serviceImpl.checkToken((mlh.pavan.grpc.Stackoverflow.CheckTokenRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((mlh.pavan.grpc.Stackoverflow.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LogoutResponse>) responseObserver);
          break;
        case METHODID_CHANGE_PASSWORD:
          serviceImpl.changePassword((mlh.pavan.grpc.Stackoverflow.ChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangePasswordResponse>) responseObserver);
          break;
        case METHODID_CHANGE_USER_NAME:
          serviceImpl.changeUserName((mlh.pavan.grpc.Stackoverflow.ChangeUserNameRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserNameResponse>) responseObserver);
          break;
        case METHODID_CHANGE_DESCRIPTION:
          serviceImpl.changeDescription((mlh.pavan.grpc.Stackoverflow.ChangeDescriptionRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeDescriptionResponse>) responseObserver);
          break;
        case METHODID_CHANGE_SKILL:
          serviceImpl.changeSkill((mlh.pavan.grpc.Stackoverflow.ChangeSkillRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeSkillResponse>) responseObserver);
          break;
        case METHODID_ADD_SKILL:
          serviceImpl.addSkill((mlh.pavan.grpc.Stackoverflow.AddSkillRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.AddSkillResponse>) responseObserver);
          break;
        case METHODID_DELETE_SKILL:
          serviceImpl.deleteSkill((mlh.pavan.grpc.Stackoverflow.DeleteSkillRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteSkillResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((mlh.pavan.grpc.Stackoverflow.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.DeleteUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_RATING:
          serviceImpl.updateRating((mlh.pavan.grpc.Stackoverflow.UpdateRatingRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.UpdateRatingResponse>) responseObserver);
          break;
        case METHODID_CHANGE_USER_STATUS:
          serviceImpl.changeUserStatus((mlh.pavan.grpc.Stackoverflow.ChangeUserStatusRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.ChangeUserStatusResponse>) responseObserver);
          break;
        case METHODID_GET_USER_DETAILS_BY_ID:
          serviceImpl.getUserDetailsById((mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdRequest) request,
              (io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GetUserDetailsByIdResponse>) responseObserver);
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

  private static abstract class StackOverflowBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StackOverflowBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return mlh.pavan.grpc.Stackoverflow.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StackOverflow");
    }
  }

  private static final class StackOverflowFileDescriptorSupplier
      extends StackOverflowBaseDescriptorSupplier {
    StackOverflowFileDescriptorSupplier() {}
  }

  private static final class StackOverflowMethodDescriptorSupplier
      extends StackOverflowBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StackOverflowMethodDescriptorSupplier(String methodName) {
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
      synchronized (StackOverflowGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StackOverflowFileDescriptorSupplier())
              .addMethod(getGreetMethod())
              .addMethod(getSignUpMethod())
              .addMethod(getLoginMethod())
              .addMethod(getGetTokenMethod())
              .addMethod(getCheckTokenMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getChangePasswordMethod())
              .addMethod(getChangeUserNameMethod())
              .addMethod(getChangeDescriptionMethod())
              .addMethod(getChangeSkillMethod())
              .addMethod(getAddSkillMethod())
              .addMethod(getDeleteSkillMethod())
              .addMethod(getDeleteUserMethod())
              .addMethod(getUpdateRatingMethod())
              .addMethod(getChangeUserStatusMethod())
              .addMethod(getGetUserDetailsByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}

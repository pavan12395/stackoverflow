package mlh.pavan;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mlh.pavan.grpc.StackOverflowGrpc;
import mlh.pavan.grpc.StackOverflowGrpc.*;
import mlh.pavan.grpc.Stackoverflow.*;

import java.util.ArrayList;
import java.util.List;


public class GrpcClient
{
    public static String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjk1Njc2NjEzLCJpc3MiOiJzdGFja292ZXJmbG93IiwidXNlcklkIjoyNCwidXNlck5hbWUiOiJwYXZhbjEiLCJkZXNjcmlwdGlvbiI6ImRlc2MiLCJza2lsbHMiOiJbe1wic2tpbGxOYW1lX1wiOjMsXCJkaWZmaWN1bHR5X1wiOjIsXCJtZW1vaXplZElzSW5pdGlhbGl6ZWRcIjotMSxcInVua25vd25GaWVsZHNcIjp7XCJmaWVsZHNcIjp7fX0sXCJtZW1vaXplZFNpemVcIjotMSxcIm1lbW9pemVkSGFzaENvZGVcIjowfSx7XCJza2lsbE5hbWVfXCI6MixcImRpZmZpY3VsdHlfXCI6MixcIm1lbW9pemVkSXNJbml0aWFsaXplZFwiOi0xLFwidW5rbm93bkZpZWxkc1wiOntcImZpZWxkc1wiOnt9fSxcIm1lbW9pemVkU2l6ZVwiOi0xLFwibWVtb2l6ZWRIYXNoQ29kZVwiOjB9XSJ9.yk2R1NzleQb9inBL-xzN7z1ha2AeWZdD_fX4qNoAjlY";
    public static String refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjk1OTY5MjU1LCJpc3MiOiJzdGFja292ZXJmbG93IiwidXNlcklkIjoxNiwidXNlck5hbWUiOiJwYXZhbjEyMzQ1NiIsImRlc2NyaXB0aW9uIjoiZGVzYyIsInNraWxscyI6Ilt7XCJza2lsbE5hbWVfXCI6MyxcImRpZmZpY3VsdHlfXCI6MixcIm1lbW9pemVkSXNJbml0aWFsaXplZFwiOi0xLFwidW5rbm93bkZpZWxkc1wiOntcImZpZWxkc1wiOnt9fSxcIm1lbW9pemVkU2l6ZVwiOi0xLFwibWVtb2l6ZWRIYXNoQ29kZVwiOjB9LHtcInNraWxsTmFtZV9cIjoyLFwiZGlmZmljdWx0eV9cIjoyLFwibWVtb2l6ZWRJc0luaXRpYWxpemVkXCI6LTEsXCJ1bmtub3duRmllbGRzXCI6e1wiZmllbGRzXCI6e319LFwibWVtb2l6ZWRTaXplXCI6LTEsXCJtZW1vaXplZEhhc2hDb2RlXCI6MH1dIn0.OEl5Wndl3JWuQPEDHyKh-7QG3rIPkGrC5CVFWl33ZWc";
    public static void TestSignUpRequest(StackOverflowBlockingStub blockingStub)
    {
        Skill skill1 = Skill.newBuilder().setDifficulty(SKILL_DIFFICULTY.MEDIUM).setSkillName(SKILL_NAME.PYTHON).build();
        Skill skill2 = Skill.newBuilder().setDifficulty(SKILL_DIFFICULTY.MEDIUM).setSkillName(SKILL_NAME.JAVA).build();
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        SignUpRequest signUpRequest = SignUpRequest.newBuilder()
        .setUserName("pavan").setPassword("pass").setDescription("desc").addAllSkills(skillList).build();
        SignUpResponse signUpResponse  = blockingStub.signUp(signUpRequest);
        System.out.println(signUpResponse);
    }
    public static void TestLoginRequest(StackOverflowBlockingStub blockingStub)
    {
        LoginRequest loginRequest = LoginRequest.newBuilder().setUserName("pavan123456").setPassword("helloworld1").build();
        LoginResponse loginResponse = blockingStub.login(loginRequest);
        System.out.println(loginResponse);
    }
    public static void TestCheckTokenRequest(StackOverflowBlockingStub blockingStub)
    {
        CheckTokenRequest checkTokenRequest = CheckTokenRequest.newBuilder().setRequestHeaders(RequestHeaders.newBuilder().setAuthorization(Authorization.newBuilder().setAccessToken(accessToken).build())).build();
        CheckTokenResponse checkTokenResponse = blockingStub.checkToken(checkTokenRequest);
        System.out.println(checkTokenResponse);
    }
    public static void TestGetTokenRequest(StackOverflowBlockingStub blockingStub)
    {
        GetTokenRequest getTokenRequest = GetTokenRequest.newBuilder().setRequestHeaders(RequestHeaders.newBuilder().setAuthorization(Authorization.newBuilder().setRefreshToken(refreshToken).build()).build()).build();
        GetTokenResponse getTokenResponse = blockingStub.getToken(getTokenRequest);
        System.out.println(getTokenResponse);
    }
    public static void TestUpdatePassword(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        ChangePasswordRequest changePasswordRequest = ChangePasswordRequest.newBuilder().setRequestHeaders(requestHeaders).setPassword("helloworld").setNewPassword("helloworld1").build();
        ChangePasswordResponse changePasswordResponse = blockingStub.changePassword(changePasswordRequest);
        System.out.println(changePasswordResponse);
    }
    public static void TestUpdateUserName(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        ChangeUserNameRequest changeUserNameRequest = ChangeUserNameRequest.newBuilder().setRequestHeaders(requestHeaders).setUserName("pavan2").build();
        ChangeUserNameResponse changeUserNameResponse = blockingStub.changeUserName(changeUserNameRequest);
        System.out.println(changeUserNameResponse);
    }
    public static void TestUpdateDescription(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        ChangeDescriptionRequest changeDescriptionRequest = ChangeDescriptionRequest.newBuilder().setRequestHeaders(requestHeaders).setDescription("Hello world!").build();
        ChangeDescriptionResponse changeDescriptionResponse = blockingStub.changeDescription(changeDescriptionRequest);
        System.out.println(changeDescriptionResponse);
    }
    public static void TestChangeSkill(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        Skill skill = Skill.newBuilder().setSkillName(SKILL_NAME.JAVA).setDifficultyValue(SKILL_DIFFICULTY.HARD_VALUE).build();
        ChangeSkillRequest changeSkillRequest = ChangeSkillRequest.newBuilder().setRequestHeaders(requestHeaders).setSkill(skill).build();
        ChangeSkillResponse changeSkillResponse = blockingStub.changeSkill(changeSkillRequest);
        System.out.println(changeSkillResponse);
    }
    public static void TestAddSkill(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        Skill skill = Skill.newBuilder().setSkillName(SKILL_NAME.MYSQL).setDifficultyValue(SKILL_DIFFICULTY.HARD_VALUE).build();
        AddSkillRequest addSkillRequest = AddSkillRequest.newBuilder().setRequestHeaders(requestHeaders).setSkill(skill).build();
        AddSkillResponse addSkillResponse = blockingStub.addSkill(addSkillRequest);
        System.out.println(addSkillResponse);
    }
    public static void TestDeleteSkill(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        DeleteSkillRequest deleteSkillRequest = DeleteSkillRequest.newBuilder().setRequestHeaders(requestHeaders).setSkillName(SKILL_NAME.MYSQL).build();
        DeleteSkillResponse deleteSkillResponse = blockingStub.deleteSkill(deleteSkillRequest);
        System.out.println(deleteSkillResponse);
    }
    public static void TestDeleteUser(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        DeleteUserRequest deleteUserRequest = DeleteUserRequest.newBuilder().setRequestHeaders(requestHeaders).build();
        DeleteUserResponse deleteUserResponse = blockingStub.deleteUser(deleteUserRequest);
        System.out.println(deleteUserResponse);
    }
    public static void TestUpdateRating(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        UpdateRatingRequest updateRatingRequest = UpdateRatingRequest.newBuilder().setRequestHeaders(requestHeaders).setRating(3.45f).build();
        UpdateRatingResponse updateRatingResponse = blockingStub.updateRating(updateRatingRequest);
        System.out.println(updateRatingResponse);
    }
    public static void TestChangeUserStatus(StackOverflowBlockingStub blockingStub)
    {
        Authorization authorization = Authorization.newBuilder().setAccessToken(accessToken).build();
        RequestHeaders requestHeaders = RequestHeaders.newBuilder().setAuthorization(authorization).build();
        ChangeUserStatusRequest changeUserStatusRequest = ChangeUserStatusRequest.newBuilder().setRequestHeaders(requestHeaders).setStatus(USER_STATUS.CALL).build();
        ChangeUserStatusResponse changeUserStatusResponse = blockingStub.changeUserStatus(changeUserStatusRequest);
        System.out.println(changeUserStatusResponse);
    }
    public static void main(String args[])
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080).usePlaintext().build();

        // stubs - generate from proto

        StackOverflowBlockingStub stackOverflowBlockingStub = StackOverflowGrpc.newBlockingStub(channel);

        TestSignUpRequest(stackOverflowBlockingStub);
//        TestLoginRequest(stackOverflowBlockingStub);
//        TestCheckTokenRequest(stackOverflowBlockingStub);
//        TestGetTokenRequest(stackOverflowBlockingStub);
//        TestUpdatePassword(stackOverflowBlockingStub);
//        TestUpdateUserName(stackOverflowBlockingStub);
//        TestUpdateDescription(stackOverflowBlockingStub);
//        TestChangeSkill(stackOverflowBlockingStub);
//        TestAddSkill(stackOverflowBlockingStub);
//        TestDeleteSkill(stackOverflowBlockingStub);
//        TestDeleteUser(stackOverflowBlockingStub);
//        TestUpdateRating(stackOverflowBlockingStub);
//        TestChangeUserStatus(stackOverflowBlockingStub);
    }
}
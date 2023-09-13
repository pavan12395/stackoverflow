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
    public static void TestSignUpRequest(StackOverflowBlockingStub blockingStub)
    {
        Skill skill1 = Skill.newBuilder().setDifficulty(SKILL_DIFFICULTY.MEDIUM).setSkillName(SKILL_NAME.PYTHON).build();
        Skill skill2 = Skill.newBuilder().setDifficulty(SKILL_DIFFICULTY.MEDIUM).setSkillName(SKILL_NAME.JAVA).build();
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        SignUpRequest signUpRequest = SignUpRequest.newBuilder()
        .setUserName("pavan3213").setPassword("12341212").setDescription("desc").addAllSkills(skillList).build();
        SignUpResponse signUpResponse  = blockingStub.signUp(signUpRequest);
        System.out.println(signUpResponse);
    }
    public static void TestLoginRequest(StackOverflowBlockingStub blockingStub)
    {
        LoginRequest loginRequest = LoginRequest.newBuilder().setUserName("pavan3").setPassword("1234").build();
        LoginResponse loginResponse = blockingStub.login(loginRequest);
        System.out.println(loginResponse);
    }
    public static void TestCheckTokenRequest(StackOverflowBlockingStub blockingStub)
    {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjkzNTU4NzkwLCJpc3MiOiJzdGFja292ZXJmbG93IiwidXNlcklkIjo0LCJ1c2VyTmFtZSI6InBhdmFuMyIsImRlc2NyaXB0aW9uIjoiZGVzYyIsInNraWxscyI6Ilt7XCJza2lsbE5hbWVfXCI6MSxcImRpZmZpY3VsdHlfXCI6MSxcIm1lbW9pemVkSXNJbml0aWFsaXplZFwiOi0xLFwidW5rbm93bkZpZWxkc1wiOntcImZpZWxkc1wiOnt9fSxcIm1lbW9pemVkU2l6ZVwiOi0xLFwibWVtb2l6ZWRIYXNoQ29kZVwiOjB9LHtcInNraWxsTmFtZV9cIjowLFwiZGlmZmljdWx0eV9cIjoxLFwibWVtb2l6ZWRJc0luaXRpYWxpemVkXCI6LTEsXCJ1bmtub3duRmllbGRzXCI6e1wiZmllbGRzXCI6e319LFwibWVtb2l6ZWRTaXplXCI6LTEsXCJtZW1vaXplZEhhc2hDb2RlXCI6MH1dIn0.-UA-nWyCZmbSp5vS4BpZAmaMcBliE96A5yfxOWVlx9U";
        CheckTokenRequest checkTokenRequest = CheckTokenRequest.newBuilder().setRequestHeaders(RequestHeaders.newBuilder().setAuthorization(Authorization.newBuilder().setAccessToken(accessToken).build())).build();
        CheckTokenResponse checkTokenResponse = blockingStub.checkToken(checkTokenRequest);
        System.out.println(checkTokenResponse);
    }
    public static void TestGetTokenRequest(StackOverflowBlockingStub blockingStub)
    {
        String refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjkzODAwNzEwLCJpc3MiOiJzdGFja292ZXJmbG93IiwidXNlcklkIjo5LCJ1c2VyTmFtZSI6InBhdmFuIiwiZGVzY3JpcHRpb24iOiJkZXNjIiwic2tpbGxzIjoiW3tcInNraWxsTmFtZV9cIjoxLFwiZGlmZmljdWx0eV9cIjoxLFwibWVtb2l6ZWRJc0luaXRpYWxpemVkXCI6LTEsXCJ1bmtub3duRmllbGRzXCI6e1wiZmllbGRzXCI6e319LFwibWVtb2l6ZWRTaXplXCI6LTEsXCJtZW1vaXplZEhhc2hDb2RlXCI6MH0se1wic2tpbGxOYW1lX1wiOjAsXCJkaWZmaWN1bHR5X1wiOjEsXCJtZW1vaXplZElzSW5pdGlhbGl6ZWRcIjotMSxcInVua25vd25GaWVsZHNcIjp7XCJmaWVsZHNcIjp7fX0sXCJtZW1vaXplZFNpemVcIjotMSxcIm1lbW9pemVkSGFzaENvZGVcIjowfV0ifQ.v-DZQcMR-AIgDNM4PDfvU7sHx3gEFF1G6paW87vU2FA";
        GetTokenRequest getTokenRequest = GetTokenRequest.newBuilder().setRequestHeaders(RequestHeaders.newBuilder().setAuthorization(Authorization.newBuilder().setRefreshToken(refreshToken).build()).build()).build();
        GetTokenResponse getTokenResponse = blockingStub.getToken(getTokenRequest);
        System.out.println(getTokenResponse);
    }
    public static void TestUpdatePassword(StackOverflowBlockingStub blockingStub)
    {
        ChangePasswordRequest changePasswordRequest = ChangePasswordRequest.newBuilder().setPassword("12344445").build();
        ChangePasswordResponse changePasswordResponse = blockingStub.changePassword(changePasswordRequest);
        System.out.println(changePasswordResponse);
    }
    public static void TestUpdateUserName(StackOverflowBlockingStub blockingStub)
    {
        ChangeUserNameRequest changeUserNameRequest = ChangeUserNameRequest.newBuilder().setUserName("pavan1").build();
        ChangeUserNameResponse changeUserNameResponse = blockingStub.changeUserName(changeUserNameRequest);
        System.out.println(changeUserNameResponse);
    }
    public static void TestUpdateDescription(StackOverflowBlockingStub blockingStub)
    {
        ChangeDescriptionRequest changeDescriptionRequest = ChangeDescriptionRequest.newBuilder().setDescription("Hello world!").build();
        ChangeDescriptionResponse changeDescriptionResponse = blockingStub.changeDescription(changeDescriptionRequest);
        System.out.println(changeDescriptionResponse);
    }
    public static void TestChangeSkill(StackOverflowBlockingStub blockingStub)
    {
        Skill skill = Skill.newBuilder().setSkillName(SKILL_NAME.JAVA).setDifficultyValue(SKILL_DIFFICULTY.HARD_VALUE).build();
        ChangeSkillRequest changeSkillRequest = ChangeSkillRequest.newBuilder().setSkill(skill).build();
        ChangeSkillResponse changeSkillResponse = blockingStub.changeSkill(changeSkillRequest);
        System.out.println(changeSkillResponse);
    }
    public static void TestAddSkill(StackOverflowBlockingStub blockingStub)
    {
        Skill skill = Skill.newBuilder().setSkillName(SKILL_NAME.MYSQL).setDifficultyValue(SKILL_DIFFICULTY.HARD_VALUE).build();
        AddSkillRequest addSkillRequest = AddSkillRequest.newBuilder().setSkill(skill).build();
        AddSkillResponse addSkillResponse = blockingStub.addSkill(addSkillRequest);
        System.out.println(addSkillResponse);
    }
    public static void TestDeleteSkill(StackOverflowBlockingStub blockingStub)
    {
        DeleteSkillRequest deleteSkillRequest = DeleteSkillRequest.newBuilder().setSkillName(SKILL_NAME.MYSQL).build();
        DeleteSkillResponse deleteSkillResponse = blockingStub.deleteSkill(deleteSkillRequest);
        System.out.println(deleteSkillResponse);
    }
    public static void TestDeleteUser(StackOverflowBlockingStub blockingStub)
    {
        DeleteUserRequest deleteUserRequest = DeleteUserRequest.newBuilder().build();
        DeleteUserResponse deleteUserResponse = blockingStub.deleteUser(deleteUserRequest);
        System.out.println(deleteUserResponse);
    }
    public static void TestUpdateRating(StackOverflowBlockingStub blockingStub)
    {
        UpdateRatingRequest updateRatingRequest = UpdateRatingRequest.newBuilder().setRating(3.45f).build();
        UpdateRatingResponse updateRatingResponse = blockingStub.updateRating(updateRatingRequest);
        System.out.println(updateRatingResponse);
    }
    public static void TestChangeUserStatus(StackOverflowBlockingStub blockingStub)
    {
        ChangeUserStatusRequest changeUserStatusRequest = ChangeUserStatusRequest.newBuilder().setStatus(USER_STATUS.ACTIVE).build();
        ChangeUserStatusResponse changeUserStatusResponse = blockingStub.changeUserStatus(changeUserStatusRequest);
        System.out.println(changeUserStatusResponse);
    }
    public static void main(String args[])
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        // stubs - generate from proto

        StackOverflowBlockingStub stackOverflowBlockingStub = StackOverflowGrpc.newBlockingStub(channel);

//        TestSignUpRequest(stackOverflowBlockingStub);
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
        TestChangeUserStatus(stackOverflowBlockingStub);
    }
}
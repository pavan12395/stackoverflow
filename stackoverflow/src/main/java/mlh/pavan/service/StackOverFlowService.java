package mlh.pavan.service;

import mlh.pavan.database.QueryEngine;
import mlh.pavan.database.dao.UserDAO;
import mlh.pavan.exception.ValidateException;
import mlh.pavan.grpc.StackOverflowGrpc.*;
import mlh.pavan.grpc.Stackoverflow.*;
import mlh.pavan.utils.Utils;
import mlh.pavan.utils.Validator;

import java.sql.SQLException;
import java.util.List;

public class StackOverFlowService extends StackOverflowImplBase
{
    public QueryEngine queryEngine;

    public StackOverFlowService()
    {
        queryEngine = new QueryEngine();
    }
    @Override
    public void greet(GreetRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GreetResponse> responseObserver)
    {
        GreetResponse greetResponse = GreetResponse.newBuilder().setMessage(request.getMessage()).build();
        responseObserver.onNext(greetResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void signUp(SignUpRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.SignUpResponse> responseObserver)
    {
        try
        {
            Validator.ValidateSignUp(request);
            String passwordHash = Utils.hashPassword(request.getPassword());
            if(this.queryEngine.checkUserName(request.getUserName()))
            {
                ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages("Username Already Exists").build();
                SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).build();
                responseObserver.onNext(signUpResponse);
                responseObserver.onCompleted();
                return;
            }
            queryEngine.getDataBaseConnection().startTransaction();
            long userId = this.queryEngine.insertUser(request.getUserName(),passwordHash, request.getDescription());
            User user = User.newBuilder().setUserId(userId).setUserName(request.getUserName()).setDescription(request.getDescription()).addAllSkills(request.getSkillsList()).build();
            List<String> tokens = Utils.generateTokens(user);
            this.queryEngine.updateRefreshToken(userId,tokens.get(1));
            this.queryEngine.addSkills(userId,request.getSkillsList());
            this.queryEngine.insertLiveUser(userId);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(tokens.get(0)).setRefreshToken(tokens.get(1)).build();
            responseObserver.onNext(signUpResponse);
            queryEngine.getDataBaseConnection().commitTransaction();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(signUpResponse);
            queryEngine.getDataBaseConnection().rollBackTransaction();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(signUpResponse);

        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void login(LoginRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LoginResponse> responseObserver)
    {
        try
        {
            Validator.ValidateLogin(request);
            String userName = request.getUserName();
            String password = request.getPassword();
            UserDAO userdao = queryEngine.getUserDetails(userName);
            String hashedPassword = userdao.getPassword();
            if(!Utils.checkPassword(password,hashedPassword))
            {
                ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages("Incorrect password").build();
                LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).build();
                responseObserver.onNext(loginResponse);
                responseObserver.onCompleted();
                return;
            }
            List<Skill> userSkills = queryEngine.getUserSkills(userdao.getId());
            User user = User.newBuilder().setUserName(userName).setUserId(userdao.getId()).setDescription(userdao.getDescription()).addAllSkills(userSkills).build();
            List<String> tokens = Utils.generateTokens(user);
            this.queryEngine.updateRefreshToken(user.getUserId(),tokens.get(1));
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(tokens.get(0)).setRefreshToken(tokens.get(1)).build();
            responseObserver.onNext(loginResponse);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(loginResponse);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(loginResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void checkToken(CheckTokenRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> responseObserver)
    {
        try
        {
            Validator.ValidateCheckToken(request);
            String accessToken = request.getRequestHeaders().getAuthorization().getAccessToken();
            User user = Utils.checkToken(accessToken,"ACCESS");
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            CheckTokenResponse checkTokenResponse = CheckTokenResponse.newBuilder().setResponseHeaders(responseHeaders).setUser(user).build();
            responseObserver.onNext(checkTokenResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages("Invalid JWT token").build();
            CheckTokenResponse checkTokenResponse = CheckTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(checkTokenResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void getToken(GetTokenRequest request, io.grpc.stub.StreamObserver<GetTokenResponse> responseObserver)
    {
        try {
            Validator.ValidateGetToken(request);
            String refreshToken = request.getRequestHeaders().getAuthorization().getRefreshToken();
            if (!queryEngine.checkRefreshToken(refreshToken)) {
                ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages("404 Not found").build();
                GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
                responseObserver.onNext(getTokenResponse);
                responseObserver.onCompleted();
                return;
            }
            User user = Utils.checkToken(refreshToken,"REFRESH");
            String accessToken = Utils.generateJwtToken(user,Utils.getDate(10),"ACCESS");
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(accessToken).build();
            responseObserver.onNext(getTokenResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(getTokenResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(getTokenResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void logout(LogoutRequest request, io.grpc.stub.StreamObserver<LogoutResponse> responseObserver)
    {
        try{
            long userId = request.getUserId();
            queryEngine.updateRefreshToken(userId,"");
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            LogoutResponse logoutResponse = LogoutResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(logoutResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            LogoutResponse logoutResponse = LogoutResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(logoutResponse);
        }
    }
    @Override
    public void changePassword(ChangePasswordRequest request, io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver)
    {
        try {
            Validator.ValidateChangePassword(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            String password = request.getPassword();
            String hashPassword = Utils.hashPassword(password);
            String newPassword = request.getNewPassword();
            queryEngine.updatePassword(userId, hashPassword,newPassword);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        finally{
            responseObserver.onCompleted();
        }
    }
    @Override
    public void changeUserName(ChangeUserNameRequest request, io.grpc.stub.StreamObserver<ChangeUserNameResponse> responseObserver)
    {
        try{
            Validator.ValidateChangeUserName(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            String userName = request.getUserName();
            queryEngine.updateUserName(userId,userName);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void changeDescription(ChangeDescriptionRequest request, io.grpc.stub.StreamObserver<ChangeDescriptionResponse> responseObserver)
    {
        try{
            Validator.ValidateChangeDescription(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            String description = request.getDescription();
            queryEngine.updateDescription(userId,description);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void changeSkill(ChangeSkillRequest request, io.grpc.stub.StreamObserver<ChangeSkillResponse> responseObserver)
    {
        try{
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            Skill skill = request.getSkill();
            queryEngine.updateSkill(userId,skill);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            ChangeSkillResponse changeSkillResponse = ChangeSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeSkillResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            ChangeSkillResponse changeSkillResponse = ChangeSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }
    @Override
    public void addSkill(AddSkillRequest request, io.grpc.stub.StreamObserver<AddSkillResponse> responseObserver)
    {
        try{
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            Skill skill = request.getSkill();
            queryEngine.addSkill(userId,skill);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            AddSkillResponse addSkillResponse = AddSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(addSkillResponse);


        }
        catch (SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            AddSkillResponse addSkillResponse = AddSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(addSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteSkill(DeleteSkillRequest request, io.grpc.stub.StreamObserver<DeleteSkillResponse> responseObserver)
    {
        try{
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            int skillName = request.getSkillNameValue();
            queryEngine.deleteSkill(userId,skillName);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            DeleteSkillResponse deleteSkillResponse = DeleteSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteSkillResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            DeleteSkillResponse deleteSkillResponse = DeleteSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }

    public void deleteUser(DeleteUserRequest request, io.grpc.stub.StreamObserver<DeleteUserResponse> responseObserver)
    {
        try{
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            queryEngine.deleteSkills(userId);
            queryEngine.deleteUser(userId);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            DeleteUserResponse deleteUserResponse = DeleteUserResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteUserResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            DeleteUserResponse deleteUserResponse = DeleteUserResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteUserResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }

    public void updateRating(UpdateRatingRequest request, io.grpc.stub.StreamObserver<UpdateRatingResponse> responseObserver)
    {
        try{
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            float rating = request.getRating();
            queryEngine.updateRating(userId,rating);
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            UpdateRatingResponse updateRatingResponse = UpdateRatingResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(updateRatingResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            UpdateRatingResponse updateRatingResponse = UpdateRatingResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(updateRatingResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }

    public void changeUserStatus(ChangeUserStatusRequest request, io.grpc.stub.StreamObserver<ChangeUserStatusResponse> responseObserver)
    {
        try
        {
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),"ACCESS");
            long userId = user.getUserId();
            USER_STATUS oldStatus = queryEngine.getUserStatus(userId);
            if(oldStatus==null)
            {
                throw new Exception("Unable to Fetch User Status");
            }
            queryEngine.updateUserStatus(userId,request.getStatus());
            if(USER_STATUS.forNumber(request.getStatusValue())==USER_STATUS.QUESTION){
                // call the <address:port>/userAdded api
            }
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.SUCCESS).build();
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.DB_FAILURE).addErrorMessages(e.getMessage()).build();
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(e.getMessage()).build();
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        finally {
            responseObserver.onCompleted();
        }
    }


}



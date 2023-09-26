package mlh.pavan.service;

import mlh.pavan.Constants.Constants;
import mlh.pavan.database.QueryEngine;
import mlh.pavan.database.dao.UserDAO;
import mlh.pavan.exception.ValidateException;
import mlh.pavan.grpc.StackOverflowGrpc.*;
import mlh.pavan.grpc.Stackoverflow.*;
import mlh.pavan.utils.Utils;
import mlh.pavan.utils.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class StackOverFlowService extends StackOverflowImplBase
{
    public QueryEngine queryEngine;

    private static final Logger logger = LogManager.getLogger(StackOverFlowService.class);

    public StackOverFlowService()
    {
        queryEngine = new QueryEngine();
    }
    @Override
    public void greet(GreetRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.GreetResponse> responseObserver)
    {
        logger.info(Constants.GREET_REQUEST);
        GreetResponse greetResponse = GreetResponse.newBuilder().setMessage(request.getMessage()).build();
        responseObserver.onNext(greetResponse);
        logger.info(Constants.GREET_RESPONSE);
        responseObserver.onCompleted();
    }

    @Override
    public void signUp(SignUpRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.SignUpResponse> responseObserver)
    {
        try
        {
            Validator.ValidateSignUp(request);
            logger.info(Constants.SIGNUP_REQUEST);
            String passwordHash = Utils.hashPassword(request.getPassword());
            if(this.queryEngine.checkUserName(request.getUserName()))
            {
                throw new Exception(Constants.USERNAME_ALREADY_PRESENT);
            }
            queryEngine.getDataBaseConnection().startTransaction();
            long userId = this.queryEngine.insertUser(request.getUserName(),passwordHash, request.getDescription());
            User user = User.newBuilder().setUserId(userId).setUserName(request.getUserName()).setDescription(request.getDescription()).addAllSkills(request.getSkillsList()).build();
            List<String> tokens = Utils.generateTokens(user);
            this.queryEngine.updateRefreshToken(userId,tokens.get(1));
            this.queryEngine.addSkills(userId,request.getSkillsList());
            this.queryEngine.insertLiveUser(userId);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(tokens.get(0)).setRefreshToken(tokens.get(1)).build();
            responseObserver.onNext(signUpResponse);
            queryEngine.getDataBaseConnection().commitTransaction();
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(signUpResponse);
            queryEngine.getDataBaseConnection().rollBackTransaction();
            logger.error(Constants.SIGNUP_ERROR_LOG,e.getMessage());
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            SignUpResponse signUpResponse = SignUpResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(signUpResponse);
            logger.error(Constants.SIGNUP_ERROR_LOG,e.getMessage());

        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.SIGNUP_RESPONSE);
        }
    }
    @Override
    public void login(LoginRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.LoginResponse> responseObserver)
    {
        try
        {
            logger.info(Constants.LOGIN_REQUEST);
            Validator.ValidateLogin(request);
            String userName = request.getUserName();
            String password = request.getPassword();
            UserDAO userdao = queryEngine.getUserDetails(userName);
            String hashedPassword = userdao.getPassword();
            if(!Utils.checkPassword(password,hashedPassword))
            {
                throw new Exception(Constants.INCORRECT_PASSWORD);
            }
            List<Skill> userSkills = queryEngine.getUserSkills(userdao.getId());
            User user = User.newBuilder().setUserName(userName).setUserId(userdao.getId()).setDescription(userdao.getDescription()).addAllSkills(userSkills).build();
            List<String> tokens = Utils.generateTokens(user);
            this.queryEngine.updateRefreshToken(user.getUserId(),tokens.get(1));
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(tokens.get(0)).setRefreshToken(tokens.get(1)).build();
            responseObserver.onNext(loginResponse);
        }
        catch(SQLException e)
        {
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(loginResponse);
            logger.error(Constants.LOGIN_ERROR_LOG,e.getMessage());
        }
        catch(Exception e)
        {
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            LoginResponse loginResponse = LoginResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(loginResponse);
            logger.error(Constants.LOGIN_ERROR_LOG,e.getMessage());
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.LOGIN_RESPONSE);
        }
    }
    @Override
    public void checkToken(CheckTokenRequest request, io.grpc.stub.StreamObserver<mlh.pavan.grpc.Stackoverflow.CheckTokenResponse> responseObserver)
    {
        try
        {
            logger.info(Constants.CHECK_TOKEN_REQUEST);
            Validator.ValidateCheckToken(request);
            String accessToken = request.getRequestHeaders().getAuthorization().getAccessToken();
            User user = Utils.checkToken(accessToken,Constants.ACCESS);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            CheckTokenResponse checkTokenResponse = CheckTokenResponse.newBuilder().setResponseHeaders(responseHeaders).setUser(user).build();
            responseObserver.onNext(checkTokenResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.CHECK_TOKEN_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(StatusCode.INTERNAL_ERROR).addErrorMessages(Constants.INVALID_JWT).build();
            CheckTokenResponse checkTokenResponse = CheckTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(checkTokenResponse);
        }
        finally {
            logger.info(Constants.CHECK_TOKEN_RESPONSE);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void getToken(GetTokenRequest request, io.grpc.stub.StreamObserver<GetTokenResponse> responseObserver)
    {
        try {
            logger.info(Constants.GET_TOKEN_REQUEST);
            Validator.ValidateGetToken(request);
            String refreshToken = request.getRequestHeaders().getAuthorization().getRefreshToken();
            if (!queryEngine.checkRefreshToken(refreshToken)) {
                throw new Exception(Constants.NOTFOUND);
            }
            User user = Utils.checkToken(refreshToken,Constants.REFRESH);
            String accessToken = Utils.generateJwtToken(user,Utils.getDate(Constants.ACCESS_EXPIRY),Constants.ACCESS);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).setAccessToken(accessToken).build();
            responseObserver.onNext(getTokenResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.GET_TOKEN_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(getTokenResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.GET_TOKEN_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            GetTokenResponse getTokenResponse = GetTokenResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(getTokenResponse);
        }
        finally {
            logger.info(Constants.GET_TOKEN_RESPONSE);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void logout(LogoutRequest request, io.grpc.stub.StreamObserver<LogoutResponse> responseObserver)
    {
        try{
            logger.info(Constants.LOGOUT_REQUEST);
            long userId = request.getUserId();
            queryEngine.updateRefreshToken(userId,Constants.EMPTY_REFRESH_TOKEN);
        }
        catch(SQLException e)
        {
            logger.error(Constants.LOGOUT_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            LogoutResponse logoutResponse = LogoutResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(logoutResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.LOGOUT_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            LogoutResponse logoutResponse = LogoutResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(logoutResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.LOGOUT_RESPONSE);
        }
    }
    @Override
    public void changePassword(ChangePasswordRequest request, io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver)
    {
        try {
            logger.info(Constants.CHANGE_PASSWORD_REQUEST);
            Validator.ValidateChangePassword(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            String password = request.getPassword();
            String hashPassword = Utils.hashPassword(password);
            String newHashPassword = Utils.hashPassword(request.getNewPassword());
            queryEngine.updatePassword(userId, hashPassword,newHashPassword);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.CHANGE_PASSWORD_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.CHANGE_PASSWORD_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            ChangePasswordResponse changePasswordResponse = ChangePasswordResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changePasswordResponse);
        }
        finally{
            logger.info(Constants.CHANGE_PASSWORD_RESPONSE);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void changeUserName(ChangeUserNameRequest request, io.grpc.stub.StreamObserver<ChangeUserNameResponse> responseObserver)
    {
        try{
            logger.info(Constants.CHANGE_USERNAME_REQUEST);
            Validator.ValidateChangeUserName(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            String userName = request.getUserName();
            if(queryEngine.checkUserName(userName))
            {
                throw new Exception(Constants.USERNAME_ALREADY_PRESENT);
            }
            queryEngine.updateUserName(userId,userName);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.CHANGE_USERNAME_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.CHANGE_USERNAME_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            ChangeUserNameResponse changeUserNameResponse = ChangeUserNameResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserNameResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.CHANGE_USERNAME_RESPONSE);
        }
    }
    @Override
    public void changeDescription(ChangeDescriptionRequest request, io.grpc.stub.StreamObserver<ChangeDescriptionResponse> responseObserver)
    {
        try{
            logger.info(Constants.CHANGE_DESCRIPTION_REQUEST);
            Validator.ValidateChangeDescription(request);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            String description = request.getDescription();
            queryEngine.updateDescription(userId,description);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.CHANGE_DESCRIPTION_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.CHANGE_DESCRIPTION_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            ChangeDescriptionResponse changeDescriptionResponse = ChangeDescriptionResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeDescriptionResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.CHANGE_DESCRIPTION_RESPONSE);
        }
    }
    @Override
    public void changeSkill(ChangeSkillRequest request, io.grpc.stub.StreamObserver<ChangeSkillResponse> responseObserver)
    {
        try{
            logger.info(Constants.CHANGE_SKILL_REQUEST);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            Skill skill = request.getSkill();
            queryEngine.updateSkill(userId,skill);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            ChangeSkillResponse changeSkillResponse = ChangeSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeSkillResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.CHANGE_SKILL_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            ChangeSkillResponse changeSkillResponse = ChangeSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.CHANGE_SKILL_RESPONSE);
        }
    }
    @Override
    public void addSkill(AddSkillRequest request, io.grpc.stub.StreamObserver<AddSkillResponse> responseObserver)
    {
        try{
            logger.info(Constants.ADD_SKILL_REQUEST);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            Skill skill = request.getSkill();
            queryEngine.addSkill(userId,skill);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            AddSkillResponse addSkillResponse = AddSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(addSkillResponse);
        }
        catch (SQLException e)
        {
            logger.error(Constants.ADD_SKILL_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            AddSkillResponse addSkillResponse = AddSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(addSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.ADD_SKILL_RESPONSE);
        }
    }

    @Override
    public void deleteSkill(DeleteSkillRequest request, io.grpc.stub.StreamObserver<DeleteSkillResponse> responseObserver)
    {
        try{
            logger.info(Constants.DELETE_SKILL_REQUEST);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            int skillName = request.getSkillNameValue();
            queryEngine.deleteSkill(userId,skillName);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            DeleteSkillResponse deleteSkillResponse = DeleteSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteSkillResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.DELETE_SKILL_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            DeleteSkillResponse deleteSkillResponse = DeleteSkillResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteSkillResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.DELETE_SKILL_RESPONSE);
        }
    }

    public void deleteUser(DeleteUserRequest request, io.grpc.stub.StreamObserver<DeleteUserResponse> responseObserver)
    {
        try{
            logger.info(Constants.DELETE_USER_REQUEST);
            queryEngine.getDataBaseConnection().startTransaction();
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            queryEngine.deleteSkills(userId);
            queryEngine.deleteLiveUser(userId);
            queryEngine.deleteUser(userId);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            DeleteUserResponse deleteUserResponse = DeleteUserResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteUserResponse);
            queryEngine.getDataBaseConnection().commitTransaction();
        }
        catch(SQLException e)
        {
            logger.error(Constants.DELETE_USER_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            DeleteUserResponse deleteUserResponse = DeleteUserResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(deleteUserResponse);
            queryEngine.getDataBaseConnection().rollBackTransaction();
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.DELETE_USER_RESPONSE);
        }
    }

    public void updateRating(UpdateRatingRequest request, io.grpc.stub.StreamObserver<UpdateRatingResponse> responseObserver)
    {
        try{
            logger.info(Constants.UPDATE_RATING_REQUEST);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            float rating = request.getRating();
            queryEngine.updateRating(userId,rating);
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            UpdateRatingResponse updateRatingResponse = UpdateRatingResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(updateRatingResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.UPDATE_RATING_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            UpdateRatingResponse updateRatingResponse = UpdateRatingResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(updateRatingResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.UPDATE_RATING_RESPONSE);
        }
    }

    public void changeUserStatus(ChangeUserStatusRequest request, io.grpc.stub.StreamObserver<ChangeUserStatusResponse> responseObserver)
    {
        try
        {
            logger.info(Constants.CHANGE_USER_STATUS_REQUEST);
            User user = Utils.checkToken(request.getRequestHeaders().getAuthorization().getAccessToken(),Constants.ACCESS);
            long userId = user.getUserId();
            USER_STATUS oldStatus = queryEngine.getUserStatus(userId);
            if(oldStatus==null)
            {
                throw new Exception(Constants.USER_FETCH_STATUS_UNABLE);
            }
            queryEngine.updateUserStatus(userId,request.getStatus());
            if(USER_STATUS.forNumber(request.getStatusValue())==USER_STATUS.QUESTION || oldStatus==USER_STATUS.QUESTION){
                // call the <address:port>/userAdded api
                logger.info(Constants.USER_ADDED_API);
                Utils.CallUserAddedEndPoint();
            }
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(null,StatusCode.SUCCESS);
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        catch(SQLException e)
        {
            logger.error(Constants.CHANGE_USER_STATUS_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.DB_FAILURE);
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        catch(Exception e)
        {
            logger.error(Constants.CHANGE_USER_STATUS_ERROR_LOG,e.getMessage());
            ResponseHeaders responseHeaders = Utils.getResponseHeaders(e,StatusCode.INTERNAL_ERROR);
            ChangeUserStatusResponse changeUserStatusResponse = ChangeUserStatusResponse.newBuilder().setResponseHeaders(responseHeaders).build();
            responseObserver.onNext(changeUserStatusResponse);
        }
        finally {
            responseObserver.onCompleted();
            logger.info(Constants.CHANGE_USER_STATUS_RESPONSE);
        }
    }


}



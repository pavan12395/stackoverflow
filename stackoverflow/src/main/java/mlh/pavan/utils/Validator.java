package mlh.pavan.utils;

import com.mysql.cj.util.StringUtils;
import mlh.pavan.exception.ValidateException;
import mlh.pavan.grpc.Stackoverflow.*;

public class Validator
{
    public static void ValidateSignUp(SignUpRequest signUpRequest) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(signUpRequest.getUserName()))
        {
            ValidateException validateException = new ValidateException("Empty Username");
            throw validateException;
        }
        else if(StringUtils.isEmptyOrWhitespaceOnly(signUpRequest.getDescription()))
        {
            ValidateException validateException = new ValidateException("Empty description");
            throw validateException;

        }
        else if(StringUtils.isEmptyOrWhitespaceOnly(signUpRequest.getPassword()) || signUpRequest.getPassword().length()<=3)
        {
            ValidateException validateException = new ValidateException("Minimum Length for Password Is 3");
            throw validateException;
        }
        else if(signUpRequest.getSkillsCount()==0)
        {
            ValidateException validateException = new ValidateException("Should Enter atleast 1 skill");
            throw validateException;

        }
    }
    public static void ValidateLogin(LoginRequest loginRequest) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(loginRequest.getUserName()))
        {
            ValidateException validateException = new ValidateException("Empty Username");
            throw validateException;
        }
        else if(StringUtils.isEmptyOrWhitespaceOnly(loginRequest.getPassword()) || loginRequest.getPassword().length()<=3)
        {
            ValidateException validateException = new ValidateException("Minimum Length for Password Is 3");
            throw validateException;
        }
    }
    public static void ValidateGetToken(GetTokenRequest getTokenRequest) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(getTokenRequest.getRequestHeaders().getAuthorization().getRefreshToken()))
        {
            ValidateException validateException = new ValidateException("Empty RefreshToken");
            throw validateException;
        }
    }
    public static void ValidateCheckToken(CheckTokenRequest checkTokenRequest) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(checkTokenRequest.getRequestHeaders().getAuthorization().getAccessToken()))
        {
            ValidateException validateException = new ValidateException("Empty AccessToken");
            throw validateException;
        }
    }
    public static void ValidateChangePassword(ChangePasswordRequest changePasswordRequest) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(changePasswordRequest.getRequestHeaders().getAuthorization().getAccessToken()))
        {
            ValidateException validateException = new ValidateException("Empty AccessToken");
            throw validateException;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(changePasswordRequest.getPassword()) || changePasswordRequest.getPassword().length()<=3)
        {
            ValidateException validateException = new ValidateException("Invalid Password");
            throw validateException;
        }
    }
    public static void ValidateChangeUserName(ChangeUserNameRequest request) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(request.getRequestHeaders().getAuthorization().getAccessToken()))
        {
            ValidateException validateException = new ValidateException("Empty AccessToken");
            throw validateException;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(request.getUserName()))
        {
            ValidateException validateException = new ValidateException("Empty USername");
            throw validateException;
        }
    }
    public static void ValidateChangeDescription(ChangeDescriptionRequest request) throws ValidateException
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(request.getRequestHeaders().getAuthorization().getAccessToken()))
        {
            ValidateException validateException = new ValidateException("Empty AccessToken");
            throw validateException;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(request.getDescription()))
        {
            ValidateException validateException = new ValidateException("Empty Description");
            throw validateException;
        }
    }
}
package mlh.pavan.Constants;


import io.jsonwebtoken.SignatureAlgorithm;
import mlh.pavan.utils.Utils;

import java.util.Date;

public class Constants
{
    public static String SERVER_LISTENING_MESSAGE = "starting GRPC Server";
    public static String GREET_REQUEST = "Recieved Greet Request";
    public static String SIGNUP_REQUEST = "Received SignUp Request";
    public static String LOGIN_REQUEST = "Received Login Request";
    public static String GET_TOKEN_REQUEST = "Received GetToken Request";
    public static String CHECK_TOKEN_REQUEST = "Received CheckToken Request";
    public static String LOGOUT_REQUEST = "Received Logout Request";
    public static String CHANGE_PASSWORD_REQUEST = "Received ChangePassword Request";
    public static String CHANGE_USERNAME_REQUEST = "Received ChangeUserName Request";
    public static String CHANGE_DESCRIPTION_REQUEST = "Received ChangeDescription Request";
    public static String CHANGE_SKILL_REQUEST = "Received ChangeSkill Request";
    public static String ADD_SKILL_REQUEST = "Received AddSkill Request";
    public static String DELETE_SKILL_REQUEST = "Received DeleteSkill Request";
    public static String DELETE_USER_REQUEST = "Received DeleteUser Request";
    public static String UPDATE_RATING_REQUEST = "Received UpdateRating Request";
    public static String CHANGE_USER_STATUS_REQUEST = "Received ChangeUserStatus Request";

    public static String GREET_RESPONSE = "Sent Greet Response";
    public static String SIGNUP_RESPONSE = "Sent SignUp Response";
    public static String LOGIN_RESPONSE = "Sent Login Response";
    public static String GET_TOKEN_RESPONSE = "Sent GetToken Response with userId: %s";
    public static String CHECK_TOKEN_RESPONSE = "Sent CheckToken Response with userId: %s";
    public static String LOGOUT_RESPONSE = "Sent Logout Response with userId: %s";
    public static String CHANGE_PASSWORD_RESPONSE = "Sent ChangePassword Response with userId: %s";
    public static String CHANGE_USERNAME_RESPONSE = "Sent ChangeUserName Response with userId: %s";
    public static String CHANGE_DESCRIPTION_RESPONSE = "Sent ChangeDescription Response with userId: %s";
    public static String CHANGE_SKILL_RESPONSE = "Sent ChangeSkill Response with userId: %s";
    public static String ADD_SKILL_RESPONSE = "Sent AddSkill Response with userId: %s";
    public static String DELETE_SKILL_RESPONSE = "Sent DeleteSkill Response with userId: %s";
    public static String DELETE_USER_RESPONSE = "Sent DeleteUser Response with userId: %s";
    public static String UPDATE_RATING_RESPONSE = "Sent UpdateRating Response with userId: %s";
    public static String CHANGE_USER_STATUS_RESPONSE = "Sent ChangeUserStatus Response with userId: %s";

    public static String GREET_ERROR_LOG = "Error in Greet API: %s";
    public static String SIGNUP_ERROR_LOG = "Error in SignUp API: %s";
    public static String LOGIN_ERROR_LOG = "Error in Login API: %s";
    public static String GET_TOKEN_ERROR_LOG = "Error in GetToken API: %s";
    public static String CHECK_TOKEN_ERROR_LOG = "Error in CheckToken API: %s";
    public static String LOGOUT_ERROR_LOG = "Error in Logout API: %s";
    public static String CHANGE_PASSWORD_ERROR_LOG = "Error in ChangePassword API: %s";
    public static String CHANGE_USERNAME_ERROR_LOG = "Error in ChangeUserName API: %s";
    public static String CHANGE_DESCRIPTION_ERROR_LOG = "Error in ChangeDescription API: %s";
    public static String CHANGE_SKILL_ERROR_LOG = "Error in ChangeSkill API: %s";
    public static String ADD_SKILL_ERROR_LOG = "Error in AddSkill API: %s";
    public static String DELETE_SKILL_ERROR_LOG = "Error in DeleteSkill API: %s";
    public static String DELETE_USER_ERROR_LOG = "Error in DeleteUser API: %s";
    public static String UPDATE_RATING_ERROR_LOG = "Error in UpdateRating API: %s";
    public static String CHANGE_USER_STATUS_ERROR_LOG = "Error in ChangeUserStatus API: %s";

    public static String USERNAME_ALREADY_PRESENT = "Username taken!";

    public static String INCORRECT_PASSWORD = "Incorrect Password!";

    public static String NOTFOUND = "404 NOT FOUND";

    public static String REFRESH = "REFRESH";

    public static String ACCESS = "ACCESS";

    public static int ACCESS_EXPIRY = 500000;

    public static int REFRESH_EXPIRY = 5000000;

    public static String INVALID_JWT ="Invalid JWT token";

    public static String EMPTY_REFRESH_TOKEN ="";

    public static String USER_FETCH_STATUS_UNABLE = "Unable to Fetch User Status";
    public static String USER_ADDED_API = "Calling UserAdded API";

    public static String Authorization = "Authorization";

    public static String USER_ID_CLAIM = "userId";

    public static String USERNAME_CLAIM = "userName";

    public static String DESC_CLAIM = "description";
    public static String SKILL_CLAIM = "skills";

    public static String USER_SUBJECT = "user";

    public static String ISSUER = "stackoverflow";

    public static SignatureAlgorithm SIGNING_ALGO = SignatureAlgorithm.HS256;

    public static String USER_ADDED_LOG = "Reply from User Added Endpoint : %s";

    public static String SUCCESS_DB = "Database Connection Successful";

    public static String ERR_DB = "Database Failed to make connection!";

    public static String AUTH_PROP_PATH = "auth.properties";

    public static String GET_USER_DETAILS_BY_ID_RESPONSE = "Sent GetUserDetailsById Response";

    public static String GET_USER_DETAILS_BY_ID_ERROR_LOG = "Error in GetUSerDetailsBy Id : %s";

    public static String GET_USER_DETAILS_BY_ID_REQUEST = "Recieved GetUserDetailsById Request";

}
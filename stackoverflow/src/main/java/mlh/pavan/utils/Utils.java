package mlh.pavan.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import mlh.pavan.Constants.Constants;
import mlh.pavan.grpc.Stackoverflow.*;

import java.util.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mlh.pavan.service.StackOverFlowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import javax.crypto.SecretKey;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public class Utils
{

    private static final Logger logger = LogManager.getLogger(Utils.class);

    private static Gson gson = new Gson();

    public static Date getDate(int minutes)
    {
        Date currentTime = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.MINUTE, minutes);

        Date newTime = calendar.getTime();
        return newTime;
    }


    public static String generateJwtToken(User user,Date expirationDate,String type) {
        String skillsEncodedJSON = gson.toJson(user.getSkillsList());
        String secretKey = (type.equals(Constants.ACCESS) ? TokenSecrets.getInstance().getAccessTokenSecret() : TokenSecrets.getInstance().getRefreshTokenSecret());
        String token = Jwts.builder().setSubject(Constants.USER_SUBJECT)
                .setExpiration(expirationDate)
                .setIssuer(Constants.ISSUER)
                .claim(Constants.USER_ID_CLAIM,user.getUserId())
                .claim(Constants.USERNAME_CLAIM,user.getUserName())
                .claim(Constants.DESC_CLAIM,user.getDescription())
                .claim(Constants.SKILL_CLAIM,skillsEncodedJSON)
                .signWith(Constants.SIGNING_ALGO,secretKey).compact();
        return token;
    }
    public static List<String> generateTokens(User user)
    {
        String accessToken = generateJwtToken(user,getDate(Constants.ACCESS_EXPIRY),Constants.ACCESS);
        String refreshToken = generateJwtToken(user,getDate(Constants.REFRESH_EXPIRY),Constants.REFRESH);
        List<String> tokens = new ArrayList<>();
        tokens.add(accessToken);
        tokens.add(refreshToken);
        return tokens;
    }
    // Method to hash a password
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password,PropertyReader.getInstance().getSalt());
    }

    // Method to verify a password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static User checkToken(String accessToken,String type)
    {
            String secretKey = type.equals(Constants.ACCESS) ? TokenSecrets.getInstance().getAccessTokenSecret() : TokenSecrets.getInstance().getRefreshTokenSecret();
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken);
            Claims body = claimsJws.getBody();
            Long userId = body.get(Constants.USER_ID_CLAIM, Long.class);
            String userName = body.get(Constants.USERNAME_CLAIM, String.class);
            String description = body.get(Constants.DESC_CLAIM, String.class);
            String skillsJson = body.get(Constants.SKILL_CLAIM, String.class);
            List<Skill> skillsList = gson.fromJson(skillsJson, new TypeToken<List<Skill>>() {}.getType());
            User user = User.newBuilder().setUserId(userId).setUserName(userName).setDescription(description).addAllSkills(skillsList).build();
            return user;
    }
    public static void CallUserAddedEndPoint() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertyReader.getInstance().getUserAddedEndPoint());
        httpPost.addHeader(Constants.Authorization,PropertyReader.getInstance().getUserAddedAPIKey());
        HttpResponse response = httpClient.execute(httpPost);
        logger.info(Constants.USER_ADDED_LOG,response);
    }
    public static ResponseHeaders getResponseHeaders(Exception e,StatusCode statusCode) {
        if (statusCode == StatusCode.SUCCESS) {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(statusCode).build();
            return responseHeaders;
        } else {
            ResponseHeaders responseHeaders = ResponseHeaders.newBuilder().setStatus(statusCode).addErrorMessages(e.getMessage()).build();
            return responseHeaders;
        }
    }
}
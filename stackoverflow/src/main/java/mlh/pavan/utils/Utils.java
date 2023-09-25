package mlh.pavan.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import mlh.pavan.grpc.Stackoverflow.*;

import java.util.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import javax.crypto.SecretKey;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public class Utils
{

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
        String secretKey = (type.equals("ACCESS") ? TokenSecrets.getInstance().getAccessTokenSecret() : TokenSecrets.getInstance().getRefreshTokenSecret());
        String token = Jwts.builder().setSubject("user")
                .setExpiration(expirationDate)
                .setIssuer("stackoverflow")
                .claim("userId",user.getUserId())
                .claim("userName",user.getUserName())
                .claim("description",user.getDescription())
                .claim("skills",skillsEncodedJSON)
                .signWith(SignatureAlgorithm.HS256,secretKey).compact();
        return token;
    }
    public static List<String> generateTokens(User user)
    {
        String accessToken = generateJwtToken(user,getDate(10),"ACCESS");
        String refreshToken = generateJwtToken(user,getDate(5000),"REFRESH");
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
            String secretKey = type.equals("ACCESS") ? TokenSecrets.getInstance().getAccessTokenSecret() : TokenSecrets.getInstance().getRefreshTokenSecret();
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken);
            Claims body = claimsJws.getBody();
            Long userId = body.get("userId", Long.class);
            String userName = body.get("userName", String.class);
            String description = body.get("description", String.class);
            String skillsJson = body.get("skills", String.class);
            List<Skill> skillsList = gson.fromJson(skillsJson, new TypeToken<List<Skill>>() {}.getType());
            User user = User.newBuilder().setUserId(userId).setUserName(userName).setDescription(description).addAllSkills(skillsList).build();
            return user;
    }
    public static void CallUserAddedEndPoint() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:5000/userAdded");
        httpPost.addHeader("Authorization","AIzaSyDaGmWKa4JsXZ-HjGw7ISLn_3namBGewQe");
        HttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + statusCode);
    }
}
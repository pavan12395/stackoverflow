package mlh.pavan.utils;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class TokenSecrets
{
    private String refreshTokenSecret;

    private String accessTokenSecret;

    private TokenSecrets()
    {
        Properties properties = new Properties();
            java.net.URL url = ClassLoader.getSystemResource("auth.properties");
            this.refreshTokenSecret = PropertyReader.getInstance().getRefreshTokenSecret();
            this.accessTokenSecret = PropertyReader.getInstance().getAccessTokenSecret();
    }

    public String getRefreshTokenSecret()
    {
        return this.refreshTokenSecret;
    }

    public String getAccessTokenSecret()
    {
        return this.accessTokenSecret;
    }

    private static TokenSecrets instance;

    public static TokenSecrets getInstance()
    {
        if(instance==null)
        {
            synchronized (TokenSecrets.class)
            {
                if(instance==null)
                {
                    instance = new TokenSecrets();
                }
            }
        }
        return instance;
    }
}
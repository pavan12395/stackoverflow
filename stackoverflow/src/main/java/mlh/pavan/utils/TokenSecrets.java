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
        try {

            java.net.URL url = ClassLoader.getSystemResource("auth.properties");

            try  {
                properties.load(url.openStream());
            } catch (FileNotFoundException fie) {
                fie.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            this.refreshTokenSecret = properties.getProperty("REFRESH_TOKEN_SECRET");
            this.accessTokenSecret = properties.getProperty("ACCESS_TOKEN_SECRET");

            System.out.println(this.refreshTokenSecret+" and "+this.accessTokenSecret);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
package mlh.pavan.utils;

import com.mysql.cj.util.StringUtils;
import mlh.pavan.GrpcServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
    private static final Logger logger = LogManager.getLogger(PropertyReader.class);

    private String driverName;

    private String dbConnUrl;
    private String dbPassword;
    private String dbUserName;
    private String accessTokenSecret;
    private String refreshTokenSecret;

    private Integer grpcServerPort;

    private String salt;

    private String userAddedEndPoint;

    private String userAddedAPIKey;

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public String getRefreshTokenSecret(){
        return refreshTokenSecret;
    }

    public String getDbConnUrl() {
        return dbConnUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getSalt(){return salt;}

    public Integer getGrpcServerPort(){return grpcServerPort;}

    public String getUserAddedEndPoint(){return userAddedEndPoint;}
    public String getUserAddedAPIKey(){return userAddedAPIKey;}


    private static PropertyReader instance;

    public static PropertyReader getInstance()
    {
        if(instance==null)
        {
            synchronized (PropertyReader.class)
            {
                if(instance==null)
                {
                    instance = new PropertyReader();
                }
            }
        }
        return instance;
    }
    private String readEnv(String key,String prop)
    {
            String envValue = System.getenv(key);
            return StringUtils.isEmptyOrWhitespaceOnly(envValue) ? prop : envValue;
    }
    private PropertyReader()
    {
        Properties dataBaseproperties = new Properties();
        Properties authProperties = new Properties();
        try {

            java.net.URL url = ClassLoader.getSystemResource("database.properties");
            java.net.URL url1 = ClassLoader.getSystemResource("auth.properties");
            try  {
                dataBaseproperties.load(url.openStream());
                authProperties.load(url1.openStream());
                dataBaseproperties.load(url1.openStream());
            } catch (FileNotFoundException fie) {
                fie.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            this.driverName = readEnv("database_driver",dataBaseproperties.getProperty("database.driver"));
            this.dbConnUrl = readEnv("database_url",dataBaseproperties.getProperty("database.url"));
            this.dbUserName = readEnv("database_username",dataBaseproperties.getProperty("database.username"));
            this.dbPassword = readEnv("database_password",dataBaseproperties.getProperty("database.password"));
            this.accessTokenSecret = readEnv("ACCESS_TOKEN_SECRET",authProperties.getProperty("ACCESS_TOKEN_SECRET"));
            this.refreshTokenSecret = readEnv("REFRESH_TOKEN_SECRET",authProperties.getProperty("REFRESH_TOKEN_SECRET"));
            this.salt = readEnv("PASSWORD_SALT",authProperties.getProperty("PASSWORD_SALT"));
            this.grpcServerPort = Integer.parseInt(readEnv("GRPC_SERVER_PORT",authProperties.getProperty("GRPC_SERVER_PORT")));
            this.userAddedEndPoint = readEnv("USER_ADDED_ENDPOINT",authProperties.getProperty("USER_ADDED_ENDPOINT"));
            this.userAddedAPIKey = readEnv("USER_ADDED_APIKEY",authProperties.getProperty("USER_ADDED_APIKEY"));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
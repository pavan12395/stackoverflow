package mlh.pavan.database;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
public class DataBaseConnection
{
    private Connection connection;

    private boolean isEmptyConnection(){
        if(connection==null)
        {
            return true;
        }
        try
        {
            if(connection.isClosed())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            return true;
        }
        return false;
    }

    public Connection getConnection(){
        if(this.isEmptyConnection()) {
            synchronized (this) {
                if (this.isEmptyConnection()) {
                    connection = this.createConnection();
                }
            }
        }
        return connection;
    }

    private Connection createConnection()
    {
        Properties properties = new Properties();
        try {

            java.net.URL url = ClassLoader.getSystemResource("database.properties");

            try  {
                properties.load(url.openStream());
            } catch (FileNotFoundException fie) {
                fie.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            String dname = properties.getProperty("database.driver");

            String dbConnUrl = properties.getProperty("database.url");
            String dbUserName = properties.getProperty("database.username");
            String dbPassword = properties.getProperty("database.password");
            Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);
            if (dbConn != null) {
                System.out.println("Database Connection Successful");
            }
            else {
                System.out.println("Database Failed to make connection!");
            }
            return dbConn;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void startTransaction() throws SQLException
    {
        try {
            this.getConnection().setAutoCommit(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void commitTransaction()
    {
        try
        {
            this.getConnection().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void rollBackTransaction()
    {
        try
        {
            this.getConnection().rollback();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
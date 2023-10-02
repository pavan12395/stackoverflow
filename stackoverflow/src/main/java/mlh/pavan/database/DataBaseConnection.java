package mlh.pavan.database;


import mlh.pavan.Constants.Constants;
import mlh.pavan.utils.PropertyReader;

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
        try {
            String dbConnUrl = PropertyReader.getInstance().getDbConnUrl();
            String dbUserName = PropertyReader.getInstance().getDbUserName();
            String dbPassword = PropertyReader.getInstance().getDbPassword();
            Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);
            if (dbConn != null) {
                System.out.println(Constants.SUCCESS_DB);
            } else {
                System.out.println(Constants.ERR_DB);
            }
            return dbConn;
        }
        catch(SQLException e)
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
            this.getConnection().setAutoCommit(true);
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
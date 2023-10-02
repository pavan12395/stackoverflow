package mlh.pavan.database;

import mlh.pavan.database.dao.GetUserDetailsDAO;
import mlh.pavan.database.dao.UserDAO;
import mlh.pavan.grpc.Stackoverflow.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryEngine
{
    private DataBaseConnection dataBaseConnection;

    public QueryEngine()
    {
        dataBaseConnection = new DataBaseConnection();
    }


    public DataBaseConnection getDataBaseConnection()
    {
        return dataBaseConnection;
    }

    private String singleQuotes(String str)
    {
        String strWithQuotes = "'" + str + "'";
        return strWithQuotes;
    }


    private ResultSet executeSelectQuery(String query) throws SQLException
    {
        Connection connection = dataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    private long executeQuery(String query) throws SQLException {
        Connection connection = dataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            long generatedId = generatedKeys.getLong(1);
            return generatedId;
        }
        return -1;
    }
    public long insertUser(String username,String password,String description) throws SQLException
    {
        String query = Queries.AddUser;
        query = query.replace(":username",singleQuotes(username));
        query = query.replace(":password",singleQuotes(password));
        query = query.replace(":description",singleQuotes(description));
        long recordId = this.executeQuery(query);
        return recordId;
    }
    public void addSkills(long userId, List<Skill> skills) throws SQLException
    {
        for(Skill skill : skills)
        {
            addSkill(userId,skill);
        }
    }
    public void addSkill(long userId,Skill skill) throws SQLException
    {
        int skillName = skill.getSkillNameValue();
        int skillDifficulty = skill.getDifficultyValue();
        String query = Queries.AddSkill;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":skillname",String.valueOf(skillName));;
        query = query.replace(":difficulty",String.valueOf(skillDifficulty));
        this.executeQuery(query);
    }
    public void updateRefreshToken(long userId,String refreshToken) throws SQLException
    {
        String query = Queries.UpdateRefreshToken;
        query = query.replace(":id",String.valueOf(userId));
        query = query.replace(":refreshToken",singleQuotes(refreshToken));
        long recordId = this.executeQuery(query);
    }

    public UserDAO getUserDetails(String userName) throws SQLException
    {
        String query = Queries.GetUserDetails;
        query = query.replace(":username",singleQuotes(userName));
        ResultSet resultSet = this.executeSelectQuery(query);
        while(resultSet.next())
        {
            String password = resultSet.getString("password");
            String description = resultSet.getString("description");
            long id = resultSet.getLong("id");
            return new UserDAO(id,userName,password,description);
        }
        return null;
    }

    public boolean checkUserName(String userName) throws SQLException
    {
        String query = Queries.GetUserName;
        query = query.replace(":username",singleQuotes(userName));
        ResultSet resultSet = this.executeSelectQuery(query);
        return resultSet.next();
    }
    public List<Skill> getUserSkills(long userId) throws SQLException
    {
        String query = Queries.GetSkills;
        query = query.replace(":userid",String.valueOf(userId));
        ResultSet resultSet = this.executeSelectQuery(query);
        List<Skill> skills = new ArrayList<>();
        while(resultSet.next())
        {
            int skillname = resultSet.getInt("skillname");
            int difficulty = resultSet.getInt("difficulty");
            Skill skill = Skill.newBuilder().setSkillName(SKILL_NAME.forNumber(skillname)).setDifficulty(SKILL_DIFFICULTY.forNumber(difficulty)).build();
            skills.add(skill);
        }
        return skills;
    }

    public boolean checkRefreshToken(String refreshToken) throws SQLException
    {
        String query = Queries.CheckRefreshToken;
        query = query.replace(":refreshtoken",singleQuotes(refreshToken));
        ResultSet resultSet = this.executeSelectQuery(query);
        while(resultSet.next())
        {
            int count = resultSet.getInt("count");
            return count!=0;
        }
        return false;
    }

    public void updatePassword(long userId,String password,String newPassword) throws SQLException
    {
        String query = Queries.UpdatePassword;
        query = query.replace(":password",singleQuotes(password));
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":newpassword",singleQuotes(newPassword));
        this.executeQuery(query);
    }
    public void updateUserName(long userId,String userName) throws SQLException
    {
        String query = Queries.UpdateUserName;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":username",singleQuotes(userName));
        this.executeQuery(query);
    }
    public void updateDescription(long userId,String description) throws SQLException
    {
        String query = Queries.UpdateDescription;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":description",singleQuotes(description));
        this.executeQuery(query);
    }
    public void updateSkill(long userId,Skill skill) throws SQLException
    {
        String query = Queries.UpdateSkill;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":skillname",String.valueOf(skill.getSkillNameValue()));
        query = query.replace(":difficulty",String.valueOf(skill.getDifficultyValue()));
        this.executeQuery(query);
    }
    public void deleteSkill(long userId,int skillName) throws SQLException
    {
        String query = Queries.DeleteSkill;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":skillname",String.valueOf(skillName));
        this.executeQuery(query);
    }
    public void deleteSkills(long userId) throws SQLException
    {
        String query = Queries.DeleteSKills;
        query = query.replace(":userid",String.valueOf(userId));
        this.executeQuery(query);
    }
    public void deleteUser(long userId) throws SQLException
    {
        String query = Queries.DeleteUser;
        query = query.replace(":userid",String.valueOf(userId));
        this.executeQuery(query);
    }
    public void updateRating(long userId,float rating) throws SQLException
    {
        String query = Queries.UpdateRating;
        query = query.replace(":userid",String.valueOf(userId));
        query = query.replace(":rating",String.valueOf(rating));
        this.executeQuery(query);
    }
    public void updateUserStatus(long userId,USER_STATUS userStatus,String webrtcSecret) throws SQLException
    {
        String query = Queries.ChangeUserStatus;
        query = query.replace(":id",String.valueOf(userId));
        query = query.replace(":user_status",String.valueOf(userStatus.getNumber()));
        query = query.replace(":webrtc_secret",singleQuotes(webrtcSecret.substring(1,webrtcSecret.length()-1)));
        System.out.println(query);
        this.executeQuery(query);
    }
    public void insertLiveUser(long userId) throws SQLException
    {
        String query = Queries.InsertLiveUser;
        query = query.replace(":id",String.valueOf(userId));
        this.executeQuery(query);
    }
    public USER_STATUS getUserStatus(long userId) throws SQLException
    {
        String query = Queries.GetUserStatus;
        query = query.replace(":id",String.valueOf(userId));
        ResultSet resultSet = this.executeSelectQuery(query);
        while(resultSet.next())
        {
            int status = resultSet.getInt("status");
            return USER_STATUS.forNumber(status);
        }
        return null;
    }
    public void deleteLiveUser(long userId) throws SQLException
    {
        String query = Queries.DeleteLiveUser;
        query = query.replace(":id",String.valueOf(userId));
        this.executeQuery(query);
    }
    public GetUserDetailsDAO getUserDetailsById(long userId) throws SQLException{
        String query = Queries.GetUserDetailsById;
        query = query.replace(":id",String.valueOf(userId));
        ResultSet resultSet = this.executeSelectQuery(query);
        while(resultSet.next())
        {
            String username = resultSet.getString("username");
            double rating = resultSet.getDouble("rating");
            GetUserDetailsDAO getUserDetailsDAO = new GetUserDetailsDAO(username,rating);
            return getUserDetailsDAO;
        }
        return null;
    }
}

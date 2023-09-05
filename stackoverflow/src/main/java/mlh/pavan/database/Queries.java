package mlh.pavan.database;


public class
Queries
{
    public static final String AddUser = "insert into users(username,password,description) VALUES(:username,:password,:description)";
    public static final String UpdateRefreshToken = "update users set refreshToken=:refreshToken where id = :id";

    public static final String AddSkill = "insert into skills(userid,skillname,difficulty) VALUES(:userid,:skillname,:difficulty)";

    public static final String GetUserDetails = "select id,password,description from users where username=:username";

    public static final String GetUserName = "select id from users where username=:username";

    public static final String GetSkills = "select skillname,difficulty from skills where userid=:userid";

    public static final String CheckRefreshToken = "select count(*) as count from users where refreshToken=:refreshtoken";

    public static final String UpdatePassword = "update users set password=:newpassword where id=:userid and password=:password";

    public static final String UpdateUserName = "update users set username=:username where id=:userid";
    public static final String UpdateDescription = "update users set description=:description where id=:userid";

    public static final String UpdateSkill = "update skills set difficulty=:difficulty where userid=:userid and skillname=:skillname";

    public static final String DeleteSkill = "delete from skills where userid=:userid and skillname=:skillname";

    public static final String DeleteSKills = "delete from skills where userid=:userid";

    public static final String DeleteUser = "delete from users where id=:userid";

    public static final String UpdateRating = "update users set rating=:rating where id=:userid";

    public static final String ChangeUserStatus = "update users set user_status=:user_status where id=:id";

}
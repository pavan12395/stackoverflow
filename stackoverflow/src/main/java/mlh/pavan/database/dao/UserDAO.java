package mlh.pavan.database.dao;


import mlh.pavan.grpc.Stackoverflow.*;

import java.util.List;


public class UserDAO {
    private final long id;
    private final String password;
    private final String username;
    private final String description;

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }



    public UserDAO(long id,String username,String password,String description) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.description = description;
    }

}

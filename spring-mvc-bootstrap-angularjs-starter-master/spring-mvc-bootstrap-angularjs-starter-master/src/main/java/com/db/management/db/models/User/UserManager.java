package com.db.management.db.models.User;

import com.db.management.dbUtils;

import java.sql.*;
/**
 * Created by Admin on 10/04/2017.
 */
public class UserManager {

    public static void Test() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

            Connection conn = dbUtils.Connect();

            Boolean status = dbUtils.Disconnect(conn);


    }

    public static User CreateUser(String name, String surname, String email, String password)
    {

        try {
            User user = new User( name, surname, email, password);
            Connection conn = dbUtils.Connect();

            String sql = "{CALL CreateUser(?,?,?,?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(0,name);
            stmt.setString(1,surname);
            stmt.setString(2,email);
            stmt.setString(3,"asdasd");
            stmt.setString(4,"hui");
            stmt.setString(5,"Fucker");
            stmt.registerOutParameter(6, Types.INTEGER);
            ResultSet rs = stmt.executeQuery(sql);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}

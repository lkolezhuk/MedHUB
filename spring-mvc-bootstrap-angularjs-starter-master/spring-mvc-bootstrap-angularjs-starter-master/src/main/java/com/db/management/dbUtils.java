package com.db.management;

import java.sql.*;
/**
 * Created by Admin on 10/04/2017.
 */
public class dbUtils {
    public static Connection Connect()  {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medhubdb?useSSL=false&serverTimezone=UTC&noAccessToProcedureBodies=true", "developer", "developer" );
            return conn;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
    public static Boolean Disconnect(Connection connection){
        try{
            connection.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

}

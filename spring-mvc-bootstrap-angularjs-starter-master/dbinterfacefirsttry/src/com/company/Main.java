package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
	// write your code here
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC", "Amici", "Amici" );
        Statement stmt = conn.createStatement();
        String sql;
        sql = "SELECT Name, Surname, Tel FROM table1";
        ResultSet rs = stmt.executeQuery(sql);

        //STEP 5: Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            String id  = rs.getString("Name");
//            int age = rs.getInt("age");
//            String first = rs.getString("first");
//            String last = rs.getString("last");

            //Display values
            System.out.print("Name: " + id);
//            System.out.print(", Surname: " + age);
//            System.out.print(", First: " + first);
//            System.out.println(", Last: " + last);
        }
        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
        conn.close();

    }
}

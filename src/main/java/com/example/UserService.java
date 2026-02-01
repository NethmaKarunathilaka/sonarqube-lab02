package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    // Use prepared statements to prevent SQL injection
    public void findUser(String username) throws Exception {

        Connection conn =
            DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", "password");

        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.executeQuery();
    }


    public void deleteUser(String username) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "password");
        String query = "DELETE FROM users WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.execute();
    } 

}

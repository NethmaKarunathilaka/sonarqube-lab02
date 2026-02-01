package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    // Use prepared statements to prevent SQL injection
    public void findUser(String username) throws SQLException {
        String url = System.getProperty("db.url", "jdbc:mysql://localhost/db");
        String dbUser = System.getProperty("db.user", "root");
        String dbPassword = System.getProperty("db.password", "");

        String query = "SELECT id, name, email FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    // Process result set
                }
            }
        }
    }

    public void deleteUser(String username) throws SQLException {
        String url = System.getProperty("db.url", "jdbc:mysql://localhost/db");
        String dbUser = System.getProperty("db.user", "root");
        String dbPassword = System.getProperty("db.password", "");
        
        String query = "DELETE FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.execute();
        }
    }

}

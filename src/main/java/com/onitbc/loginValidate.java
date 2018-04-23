package com.onitbc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class loginValidate {
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
    
    public static boolean checkUser( String privateKey ) {
        boolean st = false;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement
                ("select * from users where prikey=?");
            
            ps.setString(1, privateKey);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
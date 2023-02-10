package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetUsers {
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet  = statement.executeQuery(sql);
            while (resultSet.next())
            {
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return users;
    }
}

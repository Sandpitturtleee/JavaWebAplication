package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetUserAccounts {
    public List<UserAccounts> getAllUserAccounts(String userLogin){
        List<UserAccounts> userAccounts = new ArrayList<UserAccounts>();
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM "+ userLogin +"";
            ResultSet resultSet  = statement.executeQuery(sql);
            while (resultSet.next())
            {
                UserAccounts userAccount = new UserAccounts();
                userAccount.setType(resultSet.getString("type"));
                userAccount.setUrl(resultSet.getString("url"));
                userAccount.setLogin(resultSet.getString("login"));
                userAccount.setEmail(resultSet.getString("email"));
                userAccount.setPassword(resultSet.getString("password"));
                userAccounts.add(userAccount);
            }
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return userAccounts;
    }
}

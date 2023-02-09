package com.example.demo;

import java.sql.*;

public class User {
    private String login;
    private String email;
    private String password;

    public User ()
    {
        login="";
        email="";
        password="";
    }

    public boolean login() {
        String login_database = "";
        String password_database = "";
        String result = "";
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            //String sql = "Select * from users";
            String sql = "SELECT Count(*) FROM users WHERE login = '" + login + "' AND password = '" + password + "';";
            ResultSet resultSet  = statement.executeQuery(sql);
            resultSet.next();
            connection.setAutoCommit(false);
            if(resultSet.getInt(1)==0)
            {
                result = "false";
            }
            else {
                result = "true";
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        if(result.equals("true")) {
            return true;
        }else
            return false;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

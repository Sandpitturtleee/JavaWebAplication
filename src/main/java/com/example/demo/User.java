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
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "Select * from users";
            ResultSet resultSet  = statement.executeQuery(sql);
            connection.setAutoCommit(false);
            while ( resultSet.next() ) {
                login_database = resultSet.getString("login");
                password_database = resultSet.getString("password");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        if(login.equals(login_database)&& password.equals(password_database)) {
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

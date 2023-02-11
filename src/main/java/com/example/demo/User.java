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

    public boolean login()
    {
        boolean result = true;
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT Count(*) FROM users WHERE login = '" + login + "' AND password = '" + password + "';";
            ResultSet resultSet  = statement.executeQuery(sql);
            resultSet.next();
            connection.setAutoCommit(false);
            if(resultSet.getInt(1)==0)
            {
                resultSet.close();
                connection.close();
                result = false;
            }
            else {
                resultSet.close();
                connection.close();
                result = true;
            }
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return result;
    }
    public boolean register() {
        boolean result = true;
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT Count(*) FROM users WHERE login = '" + login +"';";
            ResultSet resultSet  = statement.executeQuery(sql);
            resultSet.next();
            connection.setAutoCommit(true);
            if(resultSet.getInt(1)==0)
            {
                Statement statementInsert= connection.createStatement();
                String sqlInsert = "INSERT INTO users (login, email, password) VALUES ('"+ login +"', '"+email+"', '"+password+"');";
                statementInsert.executeUpdate(sqlInsert);
                resultSet.close();
                statementInsert.close();
                connection.close();
                result = true;
            }
            else {
                resultSet.close();
                connection.close();
                result = false;
            }
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return result;
    }
    public void deleteUser(String login){
        try {
            //login  = "Karol";
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            PreparedStatement st = connection.prepareStatement("DELETE FROM users WHERE login = ?");
            st.setString(1,login);
            st.executeUpdate();
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
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

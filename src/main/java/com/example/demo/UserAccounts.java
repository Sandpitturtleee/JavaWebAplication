package com.example.demo;

import java.sql.*;

public class UserAccounts {
    private String type;
    private String url;
    private String login;
    private String email;
    private String password;

    public UserAccounts()
    {
        type = "";
        url = "";
        login="";
        email="";
        password="";
    }

    public boolean addAccount(String userLogin) {
        boolean result = true;
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT Count(*) FROM "+ login +"  WHERE login = '" + login +"';";
            ResultSet resultSet  = statement.executeQuery(sql);
            resultSet.next();
            connection.setAutoCommit(true);
            if(resultSet.getInt(1)==0)
            {
                Statement statementInsert= connection.createStatement();
                String sqlInsert = "INSERT INTO "+ login +"  (type, url, login, email, password) VALUES ('"+ type +"', '"+url+"', '"+login+"', '"+email+"','"+password+"');";
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
    public void deleteAccount(String userLogin,String login){
        try {
            Connection connection = DBConnector.connect();
            Statement statement = connection.createStatement();
            PreparedStatement st = connection.prepareStatement("DELETE FROM "+ userLogin +"  WHERE login = ?");
            st.setString(1,login);
            st.executeUpdate();
            statement.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

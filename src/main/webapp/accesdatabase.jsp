<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ page import="com.example.demo.DBConnector" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
<div id="right_bar" style="overflow: scroll; float: left; height: 100%; width: 65%; background-color: #008000;">
  <%
    try {
      Connection connection = DBConnector.connect();
      Statement statement = connection.createStatement();
      String sql = "Select * from users";
      ResultSet resultSet  = statement.executeQuery(sql);
      connection.setAutoCommit(false);
      while ( resultSet.next() ) {
        String  login = resultSet.getString("login");
        String  email = resultSet.getString("email");
        String  password = resultSet.getString("password");
  %>
  <div id="product" style="float: left; width: 270px; height: 410px; margin: 5px; padding: 10px; background-color: #38b000; text-align: center; border-radius: 35px;">
    <h3><%= login %></h3>
    <h3><%= email %></h3>
    <h3><%= password %></h3>
    <h3>Hello world3</h3>
  </div>
  <%
      }
      resultSet.close();
      statement.close();
      connection.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
  %>
</div>
</body>
</html>

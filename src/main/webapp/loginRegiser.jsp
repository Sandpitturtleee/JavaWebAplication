<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 12.02.2023
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <title>Login/Register</title>
</head>
<body>
<div class="header">
  <div class ="header_text">
    <h3>Password Manager</h3>
  </div>
</div>
<div class="content">
  <div class="form-container">
    <form method="post" action="login.jsp">
      <br />
      <input class="button" type="submit" value="Login">
    </form>
    <form method="post" action="register.jsp">
      <br />
      <input class="button" type="submit" value="Register">
    </form>
  </div>
</div>
<div class="footer">
  <div class ="footer_button">
    <form action="index.jsp">
      <input type="submit" class="MainPageButton" value="Main Page" name="Main Page"/>
    </form>
  </div>
</div>
</body>
</html>

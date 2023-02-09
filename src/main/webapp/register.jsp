<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<% if(request.getAttribute("message")!=null){
%>
<h3><%= request.getAttribute("message") %></h3>
<%}%>
<form action="RegisterServlet">
    Login: <br />
    <input type="text" name="login" /><br />
    Email: <br />
    <input type="text" name="email" /><br />
    Password: <br />
    <input type="password" name="password" /><br />
    Confirm Password: <br />
    <input type="password" name="password_confirm" /><br />
    <br />
    <input type="submit" value="Register" name="Register"/>
</form>
</body>
</html>

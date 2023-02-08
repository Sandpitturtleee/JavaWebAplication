<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet">
            Login: <br />
            <input type="text" name="login" /><br />
            Password: <br />
            <input type="text" name="password" /><br />
            <br />
            <input type="submit" value="Login" name="Login"/>
        </form>
    </body>
</html>

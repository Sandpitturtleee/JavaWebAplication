<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
    session.setAttribute("accessLvl", "Guest");
    %>
    <form method="post" action="login.jsp">
        <br />
        <input type="submit" value="Login">
    </form>
    <form method="post" action="register.jsp">
        <br />
        <input type="submit" value="Register">
    </form>
</body>
</html>

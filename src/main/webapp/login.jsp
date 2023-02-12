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
        <form action="LoginServlet">
            Login: <br />
            <input type="text" name="login" /><br />
            Password: <br />
            <input type="password" name="password" /><br />
            <br />
            <input type="submit" value="Login" name="Login"/>
        </form>
        <form action="register.jsp">
            <input type="submit" value="Register" name="Register"/>
        </form>
    <form action="index.jsp">
        <input type="submit" value="MainPage" name="Main Page"/>
    </form>
    </body>
</html>

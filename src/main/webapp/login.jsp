<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <div class="header">
        <div class ="header_text">
            <h3>Password Manager</h3>
        </div>
    </div>
    <div class="content">
        <div class="form-container">
            <div class="text_center">
                <% if(request.getAttribute("message")!=null){
                %>
                <h3><%= request.getAttribute("message") %></h3>
                <%}%>
            </div>
            <form action="LoginServlet">
                Login: <br />
                <input type="text" name="login" /><br />
                Password: <br />
                <input type="password" name="password" /><br />
                <br />
                <input class="button" type="submit" value="Login" name="Login"/>
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

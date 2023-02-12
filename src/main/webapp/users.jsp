<%@ page import="com.example.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <title>Users</title>
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
            <h3>Hi <%=session.getAttribute("login") %></h3>
            <% if(request.getAttribute("message")!=null){
            %>
            <h3><%= request.getAttribute("message") %></h3>
            <%}%>
        </div>
        <div class="table-container">
            <table class="table">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>Email</th>
                    <th>Password</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<User> users = (List<User>)request.getAttribute("list");
                    for(User user : users){
                        String login = user.getLogin();
                        String email = user.getEmail();
                        String password = user.getPassword();
                %>
                <tr>
                    <td><%=login%></td>
                    <td><%=email%></td>
                    <td><%=password%></td>
                    <td><form action="${pageContext.request.contextPath}/DeleteUserServlet" method="post">
                        <input type="hidden" name="loginPar" value="<%=login%>">
                        <button class="button-small" type="submit" name="button" value="button1">Delete</button>
                    </form>
                    </td>
                </tr>
                <%}
                %>
                </tbody>
            </table>
        </div>
        <form action="LogoutServlet" method="post">
            <input class="button" type="submit" value="Logout" >
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

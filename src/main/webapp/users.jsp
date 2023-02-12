<%@ page import="com.example.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h3>Hi <%=session.getAttribute("login") %></h3>
<% if(request.getAttribute("message")!=null){
%>
<h3><%= request.getAttribute("message") %></h3>
<%}%>
<table>
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
            <button type="submit" name="button" value="button1">Delete User</button>
        </form>
        </td>
    </tr>
    <%}
    %>
    </tbody>
</table>
<form action="LogoutServlet" method="post">
    <input type="submit" value="logout" >
</form>
<form action="index.jsp">
    <input type="submit" value="MainPage" name="Main Page"/>
</form>
</body>
</html>

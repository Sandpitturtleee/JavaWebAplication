<%@ page import="com.example.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.UserAccounts" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h3>Hi <%=session.getAttribute("login") %>, Login successful.</h3>
<% if(request.getAttribute("message")!=null){
%>
<h3><%= request.getAttribute("message") %></h3>
<%}%>
<table>
    <thead>
    <tr>
        <th>Type</th>
        <th>Url</th>
        <th>Login</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<UserAccounts> userAccounts = (List<UserAccounts>)request.getAttribute("list");
        for(UserAccounts userAccount : userAccounts){
            String type = userAccount.getType();
            String url = userAccount.getUrl();
            String login = userAccount.getLogin();
            String email = userAccount.getEmail();
            String password = userAccount.getPassword();
    %>
    <tr>
        <td><%=type%></td>
        <td><%=url%></td>
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
<form action="addUserAccount.jsp" method="post">
    <input type="submit" value="AddAccount" >
</form>
<form action="LogoutServlet" method="post">
    <input type="submit" value="logout" >
</form>
</body>
</html>

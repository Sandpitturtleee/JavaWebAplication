<%@ page import="com.example.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    if(userName == null) response.sendRedirect("login.jsp");
%>
<h3>Hi <%=userName %>, Login successful.</h3>
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
        <td><button onclick="<%//user.deleteUser(login);%>">Delete User</button>
        </td>
    </tr>
    <%}
    %>
    </tbody>
</table>

<form action="LogoutServlet" method="post">
    <input type="submit" value="logout" >
</form>
</body>
</html>

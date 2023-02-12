<%@ page import="com.example.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.UserAccounts" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <title>Password Manager</title>
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
                    <td><form action="${pageContext.request.contextPath}/DeleteUserAccountServlet" method="post">
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
        <br>
        <form action="addUserAccount.jsp" method="post">
            <input class="button" type="submit" value="Add" >
        </form>
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

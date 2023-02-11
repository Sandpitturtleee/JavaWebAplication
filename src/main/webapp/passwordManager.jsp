<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>passwordManager</title>
</head>
<body>
<h3>Hi <%=session.getAttribute("login") %>, Login successful.</h3>

<form action="LogoutServlet" method="post">
    <input type="submit" value="logout" >
</form>
</body>
</html>

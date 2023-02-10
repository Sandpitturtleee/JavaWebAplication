<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>passwordManager</title>
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

<form action="LogoutServlet" method="post">
    <input type="submit" value="logout" >
</form>
</body>
</html>

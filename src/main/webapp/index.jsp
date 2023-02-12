<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<% if(session.getAttribute("login")==null || session.getAttribute("login").equals("")){ %>
<form action="loginRegiser.jsp">
    <h3>Please log in or register</h3>
    <input type="submit" value="Login Register" name="OK"/>
</form>

<%} else {%>
<h3>Hi <%=session.getAttribute("login") %></h3>
<% if(request.getAttribute("message")!=null){
%>
<h3><%= request.getAttribute("message") %></h3>
<%}%>
<% if(session.getAttribute("login").equals("Admin")){ %>
<form action="LoginServlet">
    <h3>Go to users panel</h3>
    <input type="submit" value="UsersPanel" name="OK"/>
</form>

<%} else {%>
<form action="LoginServlet">
    <h3>Go to your accounts</h3>
    <input type="submit" value="UsersPanel" name="OK"/>
</form>
<%};%>
<%};%>

</body>
</html>

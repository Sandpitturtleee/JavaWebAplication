<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
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
            <% if(session.getAttribute("login")==null || session.getAttribute("login").equals("")){ %>
            <form action="loginRegiser.jsp">
                <h3>Please log in or register</h3>
                <input class="button" type="submit" value="OK" name="OK"/>
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
                <input class="button" type="submit" value="UsersPanel" name="OK"/>
            </form>

            <%} else {%>
            <form action="LoginServlet">
                <h3>Go to your accounts</h3>
                <input class="button" type="submit" value="UsersPanel" name="OK"/>
            </form>
            <%};%>
            <%};%>
        </div>
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

<%@ page import="model.dao.UserDao" %>
<%@ page import="javax.jws.soap.SOAPBinding.Use" %>
<%@ page import="model.dao.GuildDao" %>
<%@ page import="java.sql.SQLException" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <title>WoW Guild Manager</title>
</head>
<body>


<h1>Welcome <%= session.getAttribute("userName")%>
</h1>
<h1>have guild:${hasGuild}
</h1>


</body>
</html>
<%-- Created by IntelliJ IDEA. --%>
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


<h1>Welcome <%= session.getAttribute("userName")%></h1>


  </body>
</html>
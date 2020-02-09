<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if (session.getAttribute("userName") == null) {
    response.sendRedirect("login.jsp");
  }
%>
<html>
  <head>
    <title></title>
  </head>
  <body>


<h1>bienvenido</h1>


  </body>
</html>
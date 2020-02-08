<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
    if (session.getAttribute("userName") == null) {
      response.sendRedirect("login.jsp");
    }
  %>

<h1>bienvenido</h1>


  </body>
</html>
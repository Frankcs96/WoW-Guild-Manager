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

    <link href="data:image/x-icon;base64,AAABAAEAEBAAAAAAAABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcBBgnkInmz/SaMw/0CCgvkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAphtdk/8fa6T/I3m2/yeIyP9Gu+D/Vt7x/2fe7/9/5fb/AAAApgAAAAAAAAAAAAAAAAAAAABcquj/I0xs/xlUiP8dY5r/FxEN/yIYE/8fFhL/HBQQ/xkSD/8NCQj/ZeX7/zvT5P8UOWX/id/4/wAAAAAAAAAACVmA/xdMff8IDBL/GBEM/wkLGP8JCxf/CAoW/wcKF/8GChj/BgoZ/xYPDP8kYmv/KqLU/wlZgP8AAAAAAAAAABVEc/8YUYP/GxMO/xoSDf8Ur9n/ADvE/wNHgv8LDg3/AG/C/wBcw/8fFhL/HBQQ/0+65f8lf7z/AAAAAAAAAKcWSnv/GBAL/x4VD/8cFA7/GtHv/wBt0f8AW7//A9P//wB2xP8AZcT/JBoU/yIYE/8SDQv/JXqz/wAAAKcBAwXkGFCC/yseFv8nGxP/NCYd/xrR7/8AkNv/AE25/wPT//8A1+7/AG7F/x4VEP8nHBb/JBoV/yNyqf8BBQfkFEJv/RlRgP9HNCf/JhwV/w8LCP8Z0O7/DxYZ/wC/4f8AgMn/CzY5/wBzxv8UDwv/LSAZ/yoeGP8ha6D/HFWB/RVIdv0aU4L/bFVD/2hRQP8ZRUn/AI3Z/xINCv8A1ez/AH3J/xcRDf8A1u3/DQ8S/zIlHP8wIhv/IGWX/xtPeP0BBAbkHGKY/5t/af84KiD/GtHv/wB11P8+LSH/ANTr/wJCpv8qHxj/ANfu/wBxxf84KSD/NSce/x9fjv8BBAbkAAAApx5ooP9UPi//YEc2/xjM7f8AXM//ZU48/xwVEP8cFA//RjMn/wC84/8AXr3/Pi0j/yUbFf8eWIX/AAAApwAAAABHm8b/I2aV/z8vJP8TreL/A0G7/5N3Yf9VRDf/Py4j/0w4K/8AmNb/AD6x/zQmHf8fYJH/HFF8/wAAAAAAAAAAAAAC+SWCwf8SDgr/UEM6/1BEOv/Fpoz/VT8w/1pCMv9UPi//HRUQ/xwVEP8KCgr/HluJ/wAAAPkAAAAAAAAAAAABAu0NSmb/KqnW/zGhq//gw6r/6suv/5BzXv98YU7/X0c2/0g1Kf8ibaH/IGSW/0VsdP8AAAHuAAAAAAAAAAAAAAAAAAAAAAAAAKZb4fX/fOP0/3bi8/82p7P/LZe0/yiMzv8lfLj/Im2i/wAAAKkAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcFCwzkPsLV/SuZx/0CBwrkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAA+B8AAOAHAACAAQAAgAEAAIABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAQAAgAEAAIABAADgBwAA+B8AAA=="
          rel="icon" type="image/x-icon"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/indexStyle.css">
</head>
<body>
<div class="container text-center mt-4">
    <h1>Welcome ${userName}</h1>
</div>
<% if ((boolean) request.getSession(true).getAttribute("hasGuild")) { %>
<div class="container" id="guildOptions">
    <div class="row">
        <div class="col-6 text-center">
            <img class="card-img-top" src="img/allianceLogo.png" alt="Card image cap"
                 id="allianceLogo">
            <div class="card-body">
                <h4 class="card-title">Create your guild!</h4>
                <p class="card-text">First things first, create a guild to start using this app</p>
                <a href="#" class="btn btn-login">Create</a>

            </div>


        </div>
        <div class="col-6 text-center">
            <img class="card-img-top" src="img/logout.png" alt="Card image cap" id="logout">
            <div class="card-body">
                <h4 class="card-title">Change account</h4>
                <p class="card-text">Take a break... leading a guild is painfull</p>
                <a href="Logout" class="btn btn-login">Log out</a>
            </div>
        </div>
    </div>
        <% } else { %>

    <h1>no tiene guild</h1>

        <% } %>


</body>
</html>
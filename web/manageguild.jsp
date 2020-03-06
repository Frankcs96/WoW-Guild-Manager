<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Player" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=MedievalSharp&display=swap"
          rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/manageGuild.css">
    <link href="data:image/x-icon;base64,AAABAAEAEBAAAAAAAABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcBBgnkInmz/SaMw/0CCgvkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAphtdk/8fa6T/I3m2/yeIyP9Gu+D/Vt7x/2fe7/9/5fb/AAAApgAAAAAAAAAAAAAAAAAAAABcquj/I0xs/xlUiP8dY5r/FxEN/yIYE/8fFhL/HBQQ/xkSD/8NCQj/ZeX7/zvT5P8UOWX/id/4/wAAAAAAAAAACVmA/xdMff8IDBL/GBEM/wkLGP8JCxf/CAoW/wcKF/8GChj/BgoZ/xYPDP8kYmv/KqLU/wlZgP8AAAAAAAAAABVEc/8YUYP/GxMO/xoSDf8Ur9n/ADvE/wNHgv8LDg3/AG/C/wBcw/8fFhL/HBQQ/0+65f8lf7z/AAAAAAAAAKcWSnv/GBAL/x4VD/8cFA7/GtHv/wBt0f8AW7//A9P//wB2xP8AZcT/JBoU/yIYE/8SDQv/JXqz/wAAAKcBAwXkGFCC/yseFv8nGxP/NCYd/xrR7/8AkNv/AE25/wPT//8A1+7/AG7F/x4VEP8nHBb/JBoV/yNyqf8BBQfkFEJv/RlRgP9HNCf/JhwV/w8LCP8Z0O7/DxYZ/wC/4f8AgMn/CzY5/wBzxv8UDwv/LSAZ/yoeGP8ha6D/HFWB/RVIdv0aU4L/bFVD/2hRQP8ZRUn/AI3Z/xINCv8A1ez/AH3J/xcRDf8A1u3/DQ8S/zIlHP8wIhv/IGWX/xtPeP0BBAbkHGKY/5t/af84KiD/GtHv/wB11P8+LSH/ANTr/wJCpv8qHxj/ANfu/wBxxf84KSD/NSce/x9fjv8BBAbkAAAApx5ooP9UPi//YEc2/xjM7f8AXM//ZU48/xwVEP8cFA//RjMn/wC84/8AXr3/Pi0j/yUbFf8eWIX/AAAApwAAAABHm8b/I2aV/z8vJP8TreL/A0G7/5N3Yf9VRDf/Py4j/0w4K/8AmNb/AD6x/zQmHf8fYJH/HFF8/wAAAAAAAAAAAAAC+SWCwf8SDgr/UEM6/1BEOv/Fpoz/VT8w/1pCMv9UPi//HRUQ/xwVEP8KCgr/HluJ/wAAAPkAAAAAAAAAAAABAu0NSmb/KqnW/zGhq//gw6r/6suv/5BzXv98YU7/X0c2/0g1Kf8ibaH/IGSW/0VsdP8AAAHuAAAAAAAAAAAAAAAAAAAAAAAAAKZb4fX/fOP0/3bi8/82p7P/LZe0/yiMzv8lfLj/Im2i/wAAAKkAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcFCwzkPsLV/SuZx/0CBwrkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAA+B8AAOAHAACAAQAAgAEAAIABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAQAAgAEAAIABAADgBwAA+B8AAA=="
          rel="icon" type="image/x-icon"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <%
        ArrayList<Player> playerList;
        playerList = (ArrayList<Player>) request.getAttribute("playerList");
    %>

    <title>WoW Guild Manager</title>
</head>
<body>
<h1 class="text-center">${guildName} ${serverName} - ${serverRegion}</h1>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8"><h2>Guild roster</h2></div>
                <div class="col-sm-4">
                    <button onclick="window.location.href = 'CreatePlayer' " type="button" class="btn btn-login add-new"><i class="fa fa-plus"></i> Add New</button>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Class</th>
                <th>Role</th>
                <th>Level</th>
                <th>Item level</th>
                <th>Info</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Player player : playerList) {
                    out.print("<tr>\n"
                            + "                <td>" + player.getPlayerName() + "</td>\n"
                            + "                <td>" + player.getPlayerClass() + "</td>\n"
                            + "                <td>" + player.getPlayerRole() + "</td>\n"
                            + "                <td>" + player.getPlayerLevel() + "</td>\n"
                            + "                <td>" + player.getPlayerItemLevel() + "</td>\n"
                            + "                <td>" + player.getPlayerInfo() + "</td>\n"
                            + "                <td>\n"
                            + "                    <a class=\"add\" title=\"Add\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE03B;</i></a>\n"
                            + "                    <a href=\"UpdatePlayer?playerId=" + player.getPlayerId() +"\" class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>\n"
                            + "                    <a href=\"DeletePlayer?playerId=" + player.getPlayerId() + "\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>\n"
                            + "                </td>\n"
                            + "            </tr>");
                }
            %>

            </tbody>
        </table>

    </div>
    <button onclick="window.location.href = 'index' " type="button" class="btn btn-login add-new">Main menu</button>
</div>

</body>
</html>
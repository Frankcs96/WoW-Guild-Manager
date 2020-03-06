<%@ page import="db.DataBase" %>
<%@ page import="model.dao.UserDao" %>
<%@ page import="model.Server" %>
<%@ page import="java.util.ArrayList" %>
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
    <link rel="stylesheet" href="css/createPlayer.css">
    <link href="data:image/x-icon;base64,AAABAAEAEBAAAAAAAABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcBBgnkInmz/SaMw/0CCgvkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAphtdk/8fa6T/I3m2/yeIyP9Gu+D/Vt7x/2fe7/9/5fb/AAAApgAAAAAAAAAAAAAAAAAAAABcquj/I0xs/xlUiP8dY5r/FxEN/yIYE/8fFhL/HBQQ/xkSD/8NCQj/ZeX7/zvT5P8UOWX/id/4/wAAAAAAAAAACVmA/xdMff8IDBL/GBEM/wkLGP8JCxf/CAoW/wcKF/8GChj/BgoZ/xYPDP8kYmv/KqLU/wlZgP8AAAAAAAAAABVEc/8YUYP/GxMO/xoSDf8Ur9n/ADvE/wNHgv8LDg3/AG/C/wBcw/8fFhL/HBQQ/0+65f8lf7z/AAAAAAAAAKcWSnv/GBAL/x4VD/8cFA7/GtHv/wBt0f8AW7//A9P//wB2xP8AZcT/JBoU/yIYE/8SDQv/JXqz/wAAAKcBAwXkGFCC/yseFv8nGxP/NCYd/xrR7/8AkNv/AE25/wPT//8A1+7/AG7F/x4VEP8nHBb/JBoV/yNyqf8BBQfkFEJv/RlRgP9HNCf/JhwV/w8LCP8Z0O7/DxYZ/wC/4f8AgMn/CzY5/wBzxv8UDwv/LSAZ/yoeGP8ha6D/HFWB/RVIdv0aU4L/bFVD/2hRQP8ZRUn/AI3Z/xINCv8A1ez/AH3J/xcRDf8A1u3/DQ8S/zIlHP8wIhv/IGWX/xtPeP0BBAbkHGKY/5t/af84KiD/GtHv/wB11P8+LSH/ANTr/wJCpv8qHxj/ANfu/wBxxf84KSD/NSce/x9fjv8BBAbkAAAApx5ooP9UPi//YEc2/xjM7f8AXM//ZU48/xwVEP8cFA//RjMn/wC84/8AXr3/Pi0j/yUbFf8eWIX/AAAApwAAAABHm8b/I2aV/z8vJP8TreL/A0G7/5N3Yf9VRDf/Py4j/0w4K/8AmNb/AD6x/zQmHf8fYJH/HFF8/wAAAAAAAAAAAAAC+SWCwf8SDgr/UEM6/1BEOv/Fpoz/VT8w/1pCMv9UPi//HRUQ/xwVEP8KCgr/HluJ/wAAAPkAAAAAAAAAAAABAu0NSmb/KqnW/zGhq//gw6r/6suv/5BzXv98YU7/X0c2/0g1Kf8ibaH/IGSW/0VsdP8AAAHuAAAAAAAAAAAAAAAAAAAAAAAAAKZb4fX/fOP0/3bi8/82p7P/LZe0/yiMzv8lfLj/Im2i/wAAAKkAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKcFCwzkPsLV/SuZx/0CBwrkAAAApwAAAAAAAAAAAAAAAAAAAAAAAAAA+B8AAOAHAACAAQAAgAEAAIABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAQAAgAEAAIABAADgBwAA+B8AAA=="
          rel="icon" type="image/x-icon"/>

    <title>WoW Guild Manager</title>
</head>
<body>
<div id="login">
    <div class="container">

        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="CreatePlayer" method="post">
                        <h3 class="text-center">Create a new player</h3>
                        <div class="form-group">
                            <label for="playerName">Player Name:</label><br>
                            <input type="text" name="playerName" id="playerName" class="form-control"
                                   required>
                        </div>
                        <div class="form-group">
                            <label for="playerClass">Player Class:</label><br>
                            <select class="form-control" id="playerClass" name="playerClass">
                                <option value="Paladin">Paladin</option>
                                <option value="Death knight">Death knight</option>
                                <option value="Warrior">Warrior</option>
                                <option value="Priest">Priest</option>
                                <option value="Monk">Monk</option>
                                <option value="Hunter">Hunter</option>
                                <option value="Druid">Druid</option>
                                <option value="Warlock">Warlock</option>
                                <option value="Demon Hunter">Demon Hunter</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="playerRole">Player Role:</label><br>
                            <select class="form-control" id="playerRole" name="playerRole">
                                <option value="DPS">DPS</option>
                                <option value="Tank">Tank</option>
                                <option value="Healer">Healer</option>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="playerLevel">Player level:</label><br>
                            <input type="number" name="playerLevel" id="playerLevel" class="form-control"
                                   required>
                        </div>

                        <div class="form-group">
                            <label for="playerItemLevel">Player item level:</label><br>
                            <input type="number" name="playerItemLevel" id="playerItemLevel" class="form-control"
                                   required>
                        </div>

                        <div class="form-group">
                            <label for="playerInfo">Player info:</label><br>
                            <input type="text" name="playerInfo" id="playerInfo" class="form-control"
                                   required>
                        </div>



                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-login btn-md"
                                   value="Create">
                        </div>

                        <div id="register-link" class="text-right">
                            <br>
                            <a href="ManageGuild">Go back</a>
                        </div>


                    </form>


                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>

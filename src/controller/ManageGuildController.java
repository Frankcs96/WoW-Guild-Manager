package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Guild;
import model.Player;
import model.Server;
import model.dao.GuildDao;
import model.dao.PlayerDao;
import model.dao.ServerDao;

@WebServlet(urlPatterns = "/ManageGuild")
public class ManageGuildController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    GuildDao guildDao = new GuildDao();
    ServerDao serverDao = new ServerDao();
    PlayerDao playerDao = new PlayerDao();
    HttpSession session = request.getSession(false);

    try {
      Guild guild = guildDao.getUserGuildById((Integer) session.getAttribute("userId"));
      Server server = serverDao.getServerById(guild.getServerId());
      ArrayList<Player> playerList = (ArrayList<Player>) playerDao
          .getAllPlayers(guild.getId());

      request.setAttribute("guildName", guild.getGuildName());
      request.setAttribute("serverName", server.getServerName());
      request.setAttribute("serverRegion", server.getServerRegion());
      request.setAttribute("playerList", playerList);
      System.out.println(server.getServerName());

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("manageguild.jsp").forward(request, response);

  }
}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Guild;
import model.Player;
import model.dao.GuildDao;
import model.dao.PlayerDao;

@WebServlet(urlPatterns = "/UpdatePlayer")
public class UpdatePlayerController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    PlayerDao playerDao = new PlayerDao();
    GuildDao guildDao = new GuildDao();

    try {
      Guild userGuild = guildDao.getUserGuildById((int)session.getAttribute("userId"));

      playerDao.updatePlayer(
          new Player( Integer.parseInt(request.getParameter("playerId")) ,request.getParameter("playerName"), request.getParameter("playerClass"),
              request.getParameter("playerRole"), Integer.parseInt(request.getParameter("playerLevel")),
              Integer.parseInt(request.getParameter("playerItemLevel")), request.getParameter("playerInfo"),
              userGuild.getId()));

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    response.sendRedirect("ManageGuild");

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    PlayerDao playerDao = new PlayerDao();
    GuildDao guildDao = new GuildDao();
    HttpSession session = request.getSession(false);
    try {
      Guild guild = guildDao.getUserGuildById((Integer) session.getAttribute("userId"));
      Player player = playerDao.getPlayerById(Integer.parseInt(request.getParameter("playerId")));
      if (guild.getId() != player.getGuildId()) {
        response.sendRedirect("ManageGuild");
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      Player player = playerDao.getPlayerById(Integer.parseInt(request.getParameter("playerId")));
      request.setAttribute("playerId", player.getPlayerId());
      request.setAttribute("playerName", player.getPlayerName());
      request.setAttribute("playerClass", player.getPlayerClass());
      request.setAttribute("playerRole", player.getPlayerRole());
      request.setAttribute("playerLevel", player.getPlayerLevel());
      request.setAttribute("playerItemLevel", player.getPlayerItemLevel());
      request.setAttribute("playerInfo", player.getPlayerInfo());
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("updateplayer.jsp").forward(request, response);

  }
}

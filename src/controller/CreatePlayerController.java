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

@WebServlet(urlPatterns = "/CreatePlayer")
public class CreatePlayerController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    PlayerDao playerDao = new PlayerDao();
    GuildDao guildDao = new GuildDao();

    try {
      Guild userGuild = guildDao.getUserGuildById((int)session.getAttribute("userId"));

      playerDao.createPlayer(
          new Player(request.getParameter("playerName"), request.getParameter("playerClass"),
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

    request.getRequestDispatcher("createplayer.jsp").forward(request, response);
  }
}

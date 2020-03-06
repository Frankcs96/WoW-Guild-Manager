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

@WebServlet(urlPatterns = "/DeletePlayer")
public class DeletePlayerController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

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
      playerDao.deletePlayerById(Integer.parseInt(request.getParameter("playerId")));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    response.sendRedirect("ManageGuild");

  }
}

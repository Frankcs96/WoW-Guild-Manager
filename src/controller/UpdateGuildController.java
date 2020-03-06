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
import model.dao.GuildDao;
import model.dao.ServerDao;

@WebServlet(urlPatterns = "/UpdateGuild")
public class UpdateGuildController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    GuildDao guildDao = new GuildDao();
    HttpSession session = request.getSession(false);
    try {
      guildDao.updateGuild(new Guild(request.getParameter("guildName"), (int) session.getAttribute("userId"), Integer.parseInt(request.getParameter("serverList"))));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    response.sendRedirect("index");

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    ServerDao serverDao = new ServerDao();
    GuildDao guildDao = new GuildDao();
    HttpSession session = request.getSession(false);

    try {
      request.setAttribute("serverList", serverDao.getAllServers());
      request.setAttribute("userGuild", guildDao.getUserGuildById(
          (Integer) session.getAttribute("userId")));
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("updateguild.jsp").forward(request, response);
  }
}

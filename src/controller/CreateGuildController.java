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
import model.Server;
import model.dao.GuildDao;
import model.dao.ServerDao;

@WebServlet(urlPatterns = "/CreateGuild")
public class CreateGuildController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    GuildDao guildDao = new GuildDao();
    HttpSession session = request.getSession(false);
    try {
      guildDao.addGuild(new Guild (request.getParameter("guildName"), (int) session.getAttribute("userId"), Integer.parseInt(request.getParameter("serverList"))));
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

    try {
      request.setAttribute("serverList", serverDao.getAllServers());
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("createguild.jsp").forward(request, response);
  }
}

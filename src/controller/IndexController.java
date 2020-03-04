package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.GuildDao;
import model.dao.UserDao;


@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    GuildDao guildDao = new GuildDao();
    HttpSession session = request.getSession(false);

    try {
      boolean hasGuild = guildDao.userHasGuild((Integer) session.getAttribute("userId"));
      request.setAttribute("hasGuild", hasGuild);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }



    request.getRequestDispatcher("index.jsp").forward(request, response);


  }
}

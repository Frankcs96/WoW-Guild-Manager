package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UserDao;

@WebServlet(urlPatterns = "/CreateAccount")
public class CreateAccount extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String error;
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    String passwordRepeated = request.getParameter("passwordRepeated");
    UserDao userDao = new UserDao();

    if (!password.equals(passwordRepeated)) {
      error = "<div class=\"alert alert-danger\" role=\"alert\">\n"
          + "Passwords do not match\n"
          + "</div>";
      request.setAttribute("error", error);
      request.getRequestDispatcher("createaccount.jsp").forward(request,response);
    }

    try {
      if (userDao.isUserInDB(userName)) {
        error = "<div class=\"alert alert-danger\" role=\"alert\">\n"
            + "User already exists try with another one.\n"
            + "</div>";
        request.setAttribute("error", error);
        request.getRequestDispatcher("createaccount.jsp").forward(request,response);
      } else {
        userDao.addUser(userName,password);
        response.sendRedirect("login.jsp");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }




  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}

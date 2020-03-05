package filter;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.GuildDao;

@WebFilter(urlPatterns = "/CreateGuild")
public class CreateGuildFilter implements Filter {

  public void destroy() {

  }

  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws ServletException, IOException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    GuildDao guildDao = new GuildDao();

    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("userName") == null) {
      response.sendRedirect(request.getContextPath() + "/index");
      return;
    } else {
      try {
        if (guildDao.userHasGuild((Integer) session.getAttribute("userId"))) {
          response.sendRedirect(request.getContextPath() + "/index");
          return;

        }
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }

    chain.doFilter(request, response);

  }

  public void init(FilterConfig config) throws ServletException {

  }

}

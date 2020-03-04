package filter;

import java.io.IOException;
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

@WebFilter(urlPatterns = "/index")
public class LoginFilter implements Filter {

  public void destroy() {

  }

  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws ServletException, IOException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;

    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("userName") == null) {
      response.sendRedirect(request.getContextPath() + "/Login");
      return;
    } else {
      chain.doFilter(request, response);
    }

  }

  public void init(FilterConfig config) throws ServletException {

  }

}

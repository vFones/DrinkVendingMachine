package com.prog3.servlet.client;

import com.prog3.db.ormbean.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.prog3.util.LogIn.correctLogin;


@WebServlet(displayName = "log_in", urlPatterns = "/log_in")
public class LogInServlet extends HttpServlet {
  protected void doLogIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    Admin admin = correctLogin(email, password);

    if (admin == null) {
      req.getRequestDispatcher("/client" + "?err=\"true\"").include(req, resp);
    } else {
      HttpSession oldSession = req.getSession(false);
      if (oldSession != null) {
        oldSession.invalidate();
      }
      HttpSession newSession = req.getSession(true);
      newSession.setMaxInactiveInterval(5*60);
      Cookie cookie = new Cookie("admin", email);
      resp.addCookie(cookie);
      resp.sendRedirect(req.getContextPath() + "/admin");
    }
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doLogIn(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }
}
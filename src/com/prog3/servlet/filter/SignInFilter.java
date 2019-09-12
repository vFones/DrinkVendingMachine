package com.prog3.servlet.filter;


import com.prog3.hibernate.dao.AdminDao;
import com.prog3.hibernate.ormbean.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Sign in filter.
 */
public class SignInFilter implements Filter {

  private Admin correctLogin(String email, String password){
    if(email != null && password != null) {
      List<Admin> adminList = new AdminDao().query("from Admin where email='" + email +
          "' AND password='" + new AdminDao().md5Hash(password) + "'");
      if (adminList != null && adminList.size() > 0) {
        return adminList.get(0);
      }
    }
    return null;
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    // If you have any <init-param> in web.xml, then you could get them
    // here by config.getInitParameter("name") and assign it as field.
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Admin admin = correctLogin(email, password);
    String err = "";

    if (admin == null) {
      if(request.getRequestURI().endsWith("/signin"))
        err = "?err=\"true\"";

      response.sendRedirect(request.getContextPath() + "/client"+err); // No logged-in user found, so redirect to login page.
    }else {
      request.setAttribute("loggedUser", "admin");
      chain.doFilter(request, response); // Logged-in user found, so just continue request.
    }
  }

  @Override
  public void destroy() {
    // If you have assigned any expensive resources as field of
    // this Filter class, then you could clean/close them here.
  }
}
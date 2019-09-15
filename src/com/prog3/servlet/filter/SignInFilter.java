package com.prog3.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The type Sign in filter.
 */
@WebFilter(filterName = "SignIn", urlPatterns = "/admin/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE})
public class SignInFilter implements Filter {
  @Override
  public void init(FilterConfig config) throws ServletException {}

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;

    Cookie[] cookies = request.getCookies();
    Cookie cookieLogIn = null;
    if(cookies != null) {
      for (Cookie c : cookies) {
        if (c.getName().equals("admin")) {
          cookieLogIn = c;
          break;
        }
      }
    }

    if (cookieLogIn == null) {
      req.getRequestDispatcher("/client"+"?err=\"true\"").include(req, res);
    } else {
      chain.doFilter(req, res); // Logged-in user found, so just continue request.
    }
  }

  @Override
  public void destroy() {}
}
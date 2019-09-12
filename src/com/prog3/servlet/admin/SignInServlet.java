package com.prog3.servlet.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher rd = null;
    String filtered = (String) req.getAttribute("loggedUser");

    if(filtered != null){
      rd = req.getRequestDispatcher("/admin");
    }
    else{
      req.setAttribute("alert", "show");
      rd = req.getRequestDispatcher("/client");
    }
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doSignIn(req, resp);
  }
}

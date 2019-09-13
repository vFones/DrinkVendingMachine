package com.prog3.servlet.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
  protected void doAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //String loggedUser =  (String) req.getAttribute("loggedUser");
    RequestDispatcher rd = null;
    //if(loggedUser != null) {

    AdminControl.adminControl(req, resp);

    rd = req.getRequestDispatcher("/admin/index.jsp");

    /*}
    else {
      String err = "?err=\"true\"";
      rd = req.getRequestDispatcher("/client"+err);
    }*/

    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doAdmin(req, resp);
  }
}

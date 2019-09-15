package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(displayName = "admin", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
  protected void doAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String err = (String) req.getAttribute("err");
    if(err == null)
      req.setAttribute("err", "hide");

    req.setAttribute("drinkList",  new GenericDao<Product>("from Product order by prod_id").getAll());

    RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doAdmin(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doAdmin(req, resp);
  }
}

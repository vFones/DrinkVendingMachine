package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

  protected void doAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher rd = null;
    String filtered = (String) req.getAttribute("loggedUser");

    if (filtered != null) {
      GenericDao<Product> productDao = new GenericDao<Product>("from Product order by prod_id");
      List<Product> prod_list = productDao.getAll();
      req.setAttribute("list", prod_list);

      System.out.println("Succefful loginnn signinservlet filteredd");
      rd = this.getServletContext().getRequestDispatcher("/admin/index.jsp");




    } else {
      req.setAttribute("alert", "show");
      rd = req.getRequestDispatcher("/client");
      rd.forward(req, resp);
    }
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

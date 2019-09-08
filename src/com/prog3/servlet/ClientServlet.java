package com.prog3.servlet;

import com.prog3.hibernate.dao.ProductDao;
import com.prog3.hibernate.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  public ClientServlet() {
    super();
  }

  private void doClientServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductDao prod = new ProductDao();
    List<Product> prod_list = prod.getAll();
    req.setAttribute("list", prod_list);

    String message = "Select drink...";
    req.setAttribute("msg", message);

    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/client/index.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doClientServlet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

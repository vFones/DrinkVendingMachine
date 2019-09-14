package com.prog3.servlet.client;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Client servlet.
 */
@WebServlet(displayName = "client", urlPatterns = "/client")
public class ClientServlet extends HttpServlet{
  public void doClientServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("drinkList",new GenericDao<Product>("from Product order by prod_id").getAll());

    String err = req.getParameter("err");
    if(err != null)
      req.setAttribute("alert", "show");

    String msg = (String) req.getAttribute("msg");
    if(msg == null)
      msg = "Select drink...";
    req.setAttribute("msg", msg);

    String coins = (String) req.getAttribute("coins");
    if(coins == null)
      coins = "0.0";
    req.setAttribute("coins", coins);

    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/client/index.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doClientServlet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

}

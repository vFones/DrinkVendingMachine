package com.prog3.servlet.client;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Client servlet.
 */
public class ClientServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doClientServlet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  /**
   * Do client servlet.
   *
   * @param req  the req
   * @param resp the resp
   * @throws ServletException the servlet exception
   * @throws IOException      the io exception
   */
  public void doClientServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    GenericDao<Product> productDao = new GenericDao<Product>("from Product order by prod_id");
    List<Product> prod_list = productDao.getAll();

    req.setAttribute("list", prod_list);

    String alert = (String) req.getAttribute("alert");
    String err = req.getParameter("err");
    if(alert == null)
      alert = "hide";
    if(err != null)
      alert = "show";
    req.setAttribute("alert", alert);

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
}

package com.prog3.servlet;

import com.prog3.hibernate.dao.ProductDao;
import com.prog3.hibernate.ormbean.ProductBean;

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

    ProductDao prod = new ProductDao();
    List<ProductBean> prod_list = prod.query("from ProductBean order by prod_id");

    req.setAttribute("list", prod_list);

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

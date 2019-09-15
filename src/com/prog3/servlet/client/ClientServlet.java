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
 * Client servlet got the responsibility to set all informations
 */
@WebServlet(displayName = "client", urlPatterns = "/client")
public class ClientServlet extends HttpServlet{
  private void doClientServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // if here in main page invalide cookies
    if(req.getSession(false) != null)
      req.getSession(false).invalidate();

    // get all drinks
    req.setAttribute("drinkList",new GenericDao<Product>("from Product order by prod_id").getAll());

    // set a class in view used for error show
    String err = req.getParameter("err");
    if(err != null)
      req.setAttribute("alert", "show");

    //set message error
    String msg = (String) req.getAttribute("msg");
    if(msg == null)
      msg = "Select drink...";
    req.setAttribute("msg", msg);

    // update coin in drink vending machine
    String coins = (String) req.getAttribute("coins");
    if(coins == null)
      coins = "0.0";
    req.setAttribute("coins", coins);

    // return view with all information
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

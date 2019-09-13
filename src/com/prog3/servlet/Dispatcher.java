package com.prog3.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * The type Dispatcher.
 */
public class Dispatcher extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doDispatch(req, resp);
  }

  /**
   * Do dispatch.
   *
   * @param req  the req
   * @param resp the resp
   * @throws ServletException the servlet exception
   * @throws IOException      the io exception
   */
  protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getParameter("confirmPurchase") != null) {
      Enumeration attrNames = req.getAttributeNames();
      while( attrNames.hasMoreElements() ) {
        String attrName = (String) attrNames.nextElement();
        req.setAttribute( attrName, attrNames.nextElement() );
      }
      RequestDispatcher rd = req.getRequestDispatcher("/confirm");
      rd.forward(req, resp);
    }
    if(req.getParameter("rechargeKey") != null) {
      String key = req.getParameter("keyId");
      String bill = req.getParameter("bill");

      req.setAttribute("keyId", key);
      req.setAttribute("bill", bill);

      RequestDispatcher rd = req.getRequestDispatcher("/recharge");
      rd.forward(req, resp);
    }
    if(req.getParameter("adminSignin") != null){
      String email = req.getParameter("email");
      String password = req.getParameter("password");

      req.setAttribute("email", email);
      req.setAttribute("password", password);

      RequestDispatcher rd = req.getRequestDispatcher("/admin");
      rd.forward(req, resp);
    }
  }
}

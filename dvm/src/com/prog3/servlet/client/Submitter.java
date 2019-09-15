package com.prog3.servlet.client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Submitter servlet check for parameter in submit form.
 * if user want to confirm purchase than pass all elements to confirmer servlet
 * if user want to recharge key than pass only the one needed to recharger.
 */
@WebServlet(displayName = "dispatcher", urlPatterns = "/submit")
public class Submitter extends HttpServlet {
  private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getParameter("confirmPurchase") != null) {
      // get all attributes and set them to new request before forwarding.
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
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doDispatch(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }
}

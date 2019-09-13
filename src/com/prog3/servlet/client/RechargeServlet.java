package com.prog3.servlet.client;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Key;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * The type Recharge servlet.
 */
public class RechargeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Round big decimal.
   *
   * @param d            the d
   * @param decimalPlace the decimal place
   * @return the big decimal
   */
  public static BigDecimal round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd;
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doRecharge(req, resp);
  }

  /**
   * Do recharge.
   *
   * @param req  the req
   * @param resp the resp
   * @throws ServletException the servlet exception
   * @throws IOException      the io exception
   */
  protected void doRecharge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idKeyString = req.getParameter("keyId");
    String billString = req.getParameter("bill");
    float bill = parseFloat(billString.substring(0, billString.length() - 3));
    int idKey = 0;

    Key key = null;
    if(idKeyString != "" ) {
      idKey = parseInt(idKeyString);
      GenericDao<Key> keyDao = new GenericDao<Key>("from Key");

      key = keyDao.queryBean("from Key where id_key=" + idKey);
      if (key == null) {
        req.setAttribute("msg", "No key with that ID...");
      }
      else{
        key.setBalance( round(key.getBalance(), 2).floatValue() + bill);
        keyDao.update(key);
        req.setAttribute("msg", "Recharge received, key #"+ idKey +" --> balance: "+ round(key.getBalance(), 2) +"...");//keyDao.query("select balance from KeyBean where id_key="+idKey) +"...");
      }
    }
    else{
      req.setAttribute("msg", "No key selected...");
    }

    req.setAttribute("coins", "0.0");
    RequestDispatcher rd = req.getRequestDispatcher("/client");
    rd.forward(req, resp);
  }
}

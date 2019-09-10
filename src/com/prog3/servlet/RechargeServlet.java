package com.prog3.servlet;

import com.prog3.hibernate.dao.KeyDao;
import com.prog3.hibernate.ormbean.KeyBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

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

    KeyBean keyBean = null;
    if(idKeyString != "" ) {
      idKey = parseInt(idKeyString);
      KeyDao keyDao = new KeyDao();
      List<KeyBean> keyBeanList = keyDao.query("from KeyBean where id_key=" + idKey);
      if (keyBeanList == null) {
        req.setAttribute("msg", "No key with that ID...");
      }
      else{
        keyBean = keyBeanList.get(0);
        keyBean.setBalance( round(keyBean.getBalance(), 2).floatValue() + bill);
        keyDao.update(keyBean);
        req.setAttribute("msg", "Recharge received, key #"+ idKey +" --> balance: "+ round(keyBean.getBalance(), 2) +"...");//keyDao.query("select balance from KeyBean where id_key="+idKey) +"...");
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

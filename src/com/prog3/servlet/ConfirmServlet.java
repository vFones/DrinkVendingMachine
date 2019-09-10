package com.prog3.servlet;

import com.prog3.hibernate.dao.KeyDao;
import com.prog3.hibernate.dao.ProductDao;
import com.prog3.hibernate.dao.PurchaseDao;
import com.prog3.hibernate.ormbean.KeyBean;
import com.prog3.hibernate.ormbean.ProductBean;
import com.prog3.hibernate.ormbean.PurchaseBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * The type Confirm servlet.
 */
public class ConfirmServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

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
    boolean err = false;
    String keyId = null;
    String ccId = null;
    PurchaseBean purchaseBean = new PurchaseBean();
    ProductBean prod = new ProductBean();
    ProductDao productDao = new ProductDao();


    String drinkValue = req.getParameter("drink");
    if (drinkValue == null) {
      req.setAttribute("msg", "No drink selected...");
      //req.setAttribute("coins", );
      err=true;
    }
    else {
      List<ProductBean> prod_list = productDao.query("from ProductBean where prod_id=" + drinkValue);
      prod = prod_list.get(0);
    }
    float stockDiff = round(prod.getStock(),2 ).floatValue() - 0.25F;

    //TODO: observer email

    if(stockDiff < 0){
      err=true;
      req.setAttribute("msg", "Not enough stock remaining...");
    }

    if (req.getParameter("keyId") != "") {
      keyId = req.getParameter("keyId");
    }
    if(req.getParameter("ccId") != "") {
      ccId = req.getParameter("ccId");
    }

    Float coins = parseFloat( req.getParameter("coins") );
    if(coins == 0.0) {
      if (keyId == null && ccId == null) {
        req.setAttribute("msg", "No payment selected...");
        err=true;
      }
    }
    else{
      if(coins >= prod.getPrice()) {
        purchaseBean.setCash(true);
        purchaseBean.setCc_number(null);
        purchaseBean.setKeyBean(null);
        purchaseBean.setCredit_card(false);
      }
      else {
        err=true;
        req.setAttribute("msg", "Not enough coins");
        req.setAttribute("coins", coins);
      }
    }

    KeyBean keyBean = null;
    if(keyId != null && prod != null) {
      KeyDao keyDao = new KeyDao();
      List<KeyBean> keyBeanList = keyDao.query("from KeyBean where id_key="+parseInt(keyId));
      if(keyBeanList == null) {
        err=true;
        req.setAttribute("msg", "No key with that ID...");
      }
      else {
        keyBean = keyBeanList.get(0);
        keyBean.setBalance( round(keyBean.getBalance(), 2).floatValue());
        float priceDiff = round(keyBean.getBalance(), 2).floatValue() - prod.getPrice();

        if(priceDiff >= 0) {
          purchaseBean.setKeyBean(keyBean);
          purchaseBean.setCc_number(null);
          purchaseBean.setCredit_card(false);
          purchaseBean.setCash(false);

          keyBean.setBalance(priceDiff);
          keyDao.update(keyBean);
        }
        else{
          err=true;
          req.setAttribute("msg", "Payment rejected, balance on key #" +keyId+ ": " + round(keyBean.getBalance(),2)  + "...");
        }
      }
    }
    else { //credit card only
      if (ccId != null) {
        purchaseBean.setCredit_card(true);
        purchaseBean.setCc_number(ccId);
        purchaseBean.setKeyBean(null);
        purchaseBean.setCash(false);
      }
    }

    if(!err){
      prod.setStock(prod.getStock()-0.25F);
      purchaseBean.setDate(new Timestamp(System.currentTimeMillis()));
      purchaseBean.setProductBean(prod);
      productDao.update(prod);

      new PurchaseDao().save(purchaseBean);

      req.setAttribute("msg", "Payment received, delivering...");
      req.setAttribute("coins", "0.0");
    }
    //always do
    RequestDispatcher rd = req.getRequestDispatcher("/client");
    rd.forward(req, resp);
  }
}
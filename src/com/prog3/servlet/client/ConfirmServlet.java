package com.prog3.servlet.client;

import com.prog3.hibernate.dao.KeyDao;
import com.prog3.hibernate.dao.ProductDao;
import com.prog3.hibernate.dao.PurchaseDao;
import com.prog3.hibernate.ormbean.Key;
import com.prog3.hibernate.ormbean.Product;
import com.prog3.hibernate.ormbean.Purchase;
import com.prog3.servlet.client.cor.*;

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

    Timestamp date = new Timestamp(System.currentTimeMillis());

    ProductDao productDao = new ProductDao();
    Product prod = new Product();
    Purchase purchase = null;
    Key key = null;

    //Chain of Responsibility
    PaymentChain paymentChain = new PaymentChain();
    Payment payment = null;

    keyId = req.getParameter("keyId");
    ccId = req.getParameter("ccId");

    Float coins = parseFloat( req.getParameter("coins") );

    Float stockDiff = Float.MAX_VALUE;
    String drinkValue = req.getParameter("drink");
    if (drinkValue == null) {
      req.setAttribute("msg", "No drink selected...");
      req.setAttribute("coins", coins.toString());
      err = true;
    }
    else{
      List<Product> prod_list = productDao.query("from Product where prod_id=" + drinkValue);
      prod = prod_list.get(0);
      stockDiff = round(prod.getStock(),2 ).floatValue() - 0.25F;
    }

    if(stockDiff < 1) {
      //TODO: observer email
      req.setAttribute("msg", "Not enough stock remaining...");
      err = true;
    }

    purchase = new Purchase(date, prod, false, null, null);

    if(coins == 0.0 && keyId.equals("") && ccId.equals("")) {
      req.setAttribute("msg", "No payment selected...");
      err = true;
    }
    else {
      List<Key> keyList = null;
      if(keyId != null) {
        if (!keyId.equals("")) {
          keyList = new KeyDao().query("from Key where id_key=" + parseInt(keyId));
          if(keyList != null && keyList.size() > 0) {
            key = keyList.get(0);
            purchase.setKey(key);
          }
        }
      }

      if(ccId != null){
        if(!ccId.equals("")){
          purchase.setCc_number(ccId.toString());
        }
      }

      if(coins > 0.0){
        purchase.setCash(true);
      }

      payment = new Payment(coins, false, purchase);
      paymentChain.makeRequest(payment);

      //handle result from payment
      Payment.PaymentType paymentType = payment.getType();

      if ( !payment.isPaid() && paymentType != null) {
        err = true;
        switch (paymentType) {
          case CASH:
            req.setAttribute("msg", "Not enough coins...");
            req.setAttribute("coins", coins.toString());
            break;
          case KEY:
            if(keyList != null && keyList.size() > 0)
              req.setAttribute("msg", "Payment rejected, balance on key #" + keyId + ": " + round(keyList.get(0).getBalance(), 2) + "...");
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + payment.getType());
        }
      }
    }

    if(!err){
      prod.setStock(stockDiff);
      productDao.update(prod);

      new PurchaseDao().save(payment.getPurchase());

      req.setAttribute("msg", "Payment received, delivering...");
      req.setAttribute("coins", "0.0");
    }
    //always do
    RequestDispatcher rd = req.getRequestDispatcher("/client");
    rd.forward(req, resp);
  }

}
package com.prog3.servlet.client;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Key;
import com.prog3.db.ormbean.Product;
import com.prog3.db.ormbean.Purchase;
import com.prog3.servlet.client.cor.Payment;
import com.prog3.servlet.client.cor.PaymentChain;
import com.prog3.servlet.client.cor.PaymentType;
import com.prog3.util.Float2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * The type Confirm servlet.
 */
public class ConfirmServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    boolean err = false;
    String keyId = null;
    String ccId = null;

    Date date = new Date();

    GenericDao<Product> productDao = new GenericDao<Product>();
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
      prod = productDao.queryBean("from Product where prod_id=" + drinkValue);
      stockDiff = Float2.round(prod.getStock(),2 ).floatValue() - 0.25F;
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
      if(keyId != null) {
        if (!keyId.equals("")) {
          key = new GenericDao<Key>().queryBean("from Key where id_key=" + parseInt(keyId));
          if(key != null) {
            purchase.setKey(key);
          }
        }
      }

      if(ccId != null) {
        if(!ccId.equals("")) {
          purchase.setCc_number(ccId.toString());
        }
      }

      if(coins > 0.0) {
        purchase.setCash(true);
      }

      payment = new Payment(coins, false, purchase);
      paymentChain.makeRequest(payment);

      //handle result from payment
      PaymentType paymentType = payment.getType();

      if ( !payment.isPaid() && paymentType != null) {
        err = true;
        switch (paymentType) {
          case CASH:
            req.setAttribute("msg", "Not enough coins...");
            req.setAttribute("coins", coins.toString());
            break;
          case KEY:
            if(key != null)
              req.setAttribute("msg", "Payment rejected, balance on key #" + keyId + ": " + Float2.round(key.getBalance(), 2) + "...");
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + payment.getType());
        }
      }
    }

    if(!err) {
      prod.setStock(stockDiff);
      productDao.update(prod);

      new GenericDao<Purchase>().save(payment.getPurchase());

      req.setAttribute("msg", "Payment received, delivering...");
      req.setAttribute("coins", "0.0");
    }
    //always do
    RequestDispatcher rd = req.getRequestDispatcher("/client");
    rd.forward(req, resp);
  }

}
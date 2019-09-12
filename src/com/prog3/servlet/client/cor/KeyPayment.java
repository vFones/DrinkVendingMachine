package com.prog3.servlet.client.cor;

import com.prog3.hibernate.dao.KeyDao;
import com.prog3.hibernate.ormbean.Key;
import com.prog3.hibernate.ormbean.Product;

public class KeyPayment extends RequestHandler {

  public KeyPayment(RequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    Key key = p.getPurchase().getKey();
    Product prod = p.getPurchase().getProduct();
    if (key != null) {
      Float diff = key.getBalance() - prod.getPrice();
      p.setType(Payment.PaymentType.KEY);
      if (diff >= 0) {
        p.setPaid(true);
        p.getPurchase().setKey(key);
        p.getPurchase().getKey().setBalance(diff);
        new KeyDao().update(key);

        p.getPurchase().setCash(false);
        p.getPurchase().setCc_number(null);
      } else {
        p.setPaid(false);
      }
    }
    else
      super.handlePayment(p);
  }
}


    /*if(p.getKey() != null) {
      if(p.getProduct().getPrice() <= p.getKey().getBalance()) {
        p.setPaid(true);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        PurchaseBean purchase = new PurchaseBean(date, p.getProduct(), false, false, null, p.getKey());
        p.setPurchase(purchase);
        p.getKey().setBalance( p.getKey().getBalance() - p.getProduct().getPrice() );
      }
      else
        p.setPaid(false);

      p.setTypology("key");
    }
    else{
      p.setPaid(false);
      super.handlePayment(p);
    }
  }
}*/

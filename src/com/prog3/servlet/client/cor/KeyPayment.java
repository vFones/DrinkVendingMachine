package com.prog3.servlet.client.cor;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Key;
import com.prog3.db.ormbean.Product;

import static com.prog3.servlet.client.cor.EPaymentType.KEY;

public class KeyPayment extends ARequestHandler {

  public KeyPayment(ARequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    Key key = p.getPurchase().getKey();
    Product prod = p.getPurchase().getProduct();
    if (key != null) {
      Float diff = key.getBalance() - prod.getPrice();
      p.setType(KEY);
      if (diff >= 0) {
        p.setPaid(true);
        p.getPurchase().setKey(key);
        p.getPurchase().getKey().setBalance(diff);
        new GenericDao<Key>().update(key);

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

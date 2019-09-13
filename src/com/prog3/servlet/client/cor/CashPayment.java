package com.prog3.servlet.client.cor;

import static com.prog3.servlet.client.cor.PaymentType.CASH;

public class CashPayment extends RequestHandler {

  public CashPayment(RequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    if (p.getCoins() > 0.0F) {
      Float diff = p.getCoins() - p.getPurchase().getProduct().getPrice();
      p.setType(CASH);
      if( diff >= 0){
        p.setPaid(true);
        p.getPurchase().setCash(true);

        p.getPurchase().setCc_number(null);
        p.getPurchase().setKey(null);
      }
    }
    else
      super.handlePayment(p);
  }
}

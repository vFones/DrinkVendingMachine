package com.prog3.servlet.client.cor;

import static com.prog3.servlet.client.cor.EPaymentType.CASH;

/**
 * The type Cash payment @extends @ARequestHandler
 */
public class CashPayment extends ARequestHandler {
  /**
   * Instantiates a new Cash payment.
   *
   * @param r the next in Request chain
   */
  public CashPayment(ARequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    //if enough coins inserted
    if (p.getCoins() > 0.0F) {
      p.setType(CASH);
      float diff = p.getCoins() - p.getPurchase().getProduct().getPrice();
      if( diff >= 0){ //then pay and set purchase
        p.setPaid(true);
        p.getPurchase().setCash(true);

        p.getPurchase().setCc_number(null);
        p.getPurchase().setKey(null);
      }
    }
    else // handle payment down in chain
      super.handlePayment(p);
  }
}

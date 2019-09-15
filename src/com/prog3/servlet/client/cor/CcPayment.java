package com.prog3.servlet.client.cor;

import static com.prog3.servlet.client.cor.EPaymentType.CC;

/**
 * The type Cc payment.
 */
public class CcPayment extends ARequestHandler {

  /**
   * Instantiates a new Cc payment.
   *
   * @param r the Success in chain of R
   */
  public CcPayment(ARequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    // get CC number
    String ccNumber = p.getPurchase().getCc_number();
    // if CC number exist than pay drink and set purchase
    if( ccNumber != null ) {
      if( !ccNumber.equals("") ) {
        p.setPaid(true);
        p.setType(CC);
        p.getPurchase().setCc_number(ccNumber);

        p.getPurchase().setCash(false);
        p.getPurchase().setKey(null);
      }
    // otherwise go down in chain
    } else
        super.handlePayment(p);
  }
}
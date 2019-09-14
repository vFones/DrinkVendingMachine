package com.prog3.servlet.client.cor;

import static com.prog3.servlet.client.cor.EPaymentType.CC;

public class CcPayment extends ARequestHandler {

  public CcPayment(ARequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    String ccNumber = p.getPurchase().getCc_number();
    if(  ccNumber != null ){
      if( !ccNumber.equals("") ) {
        p.setPaid(true);
        p.setType(CC);
        p.getPurchase().setCc_number(ccNumber);

        p.getPurchase().setCash(false);
        p.getPurchase().setKey(null);
      }
    } else {
      super.handlePayment(p);
    }
  }
}
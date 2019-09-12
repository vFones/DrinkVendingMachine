package com.prog3.servlet.client.cor;

public class CcPayment extends RequestHandler {

  public CcPayment(RequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    String ccNumber = p.getPurchase().getCc_number();
    if(  ccNumber != null ){
      if( !ccNumber.equals("") ) {
        p.setPaid(true);
        p.setType(Payment.PaymentType.CC);
        p.getPurchase().setCc_number(ccNumber);

        p.getPurchase().setCash(false);
        p.getPurchase().setKey(null);
      }
    } else {
      super.handlePayment(p);
    }
  }
}
    /*
    if (p.getCcNumber() != null) {
      if (!p.getCcNumber().equals("")) {
        p.setPaid(true);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        PurchaseBean purchase = new PurchaseBean(date, p.getProduct(), false, true, p.getCcNumber(), null);
        p.setPurchase(purchase);
        p.setTypology("cc");
      }
    }
    else {
      p.setPaid(false);
      super.handlePayment(p);
    }
  }
}
*/
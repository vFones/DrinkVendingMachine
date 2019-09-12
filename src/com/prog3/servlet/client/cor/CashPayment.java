package com.prog3.servlet.client.cor;

public class CashPayment extends RequestHandler {

  public CashPayment(RequestHandler r) {
    super(r);
  }

  @Override
  public void handlePayment(Payment p) {
    if (p.getCoins() > 0.0F) {
      Float diff = p.getCoins() - p.getPurchase().getProduct().getPrice();
      p.setType(Payment.PaymentType.CASH);
      if( diff >= 0){
        p.setPaid(true);
        p.getPurchase().setCash(true);

        p.getPurchase().setCc_number(null);
        p.getPurchase().setKey(null);
      }
    }
    else
      super.handlePayment(p);
    /*
    if(p.getCoins() > 0.0) {
      if( p.getProduct().getPrice() <= p.getCoins() ){
        p.setPaid(true);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        PurchaseBean purchase = new PurchaseBean(date, p.getProduct(), true, false, null, null);
        p.setPurchase(purchase);
      }
      else
        p.setPaid(false);

      p.setTypology("cash");
    }
    else{
      p.setPaid(false);
      super.handlePayment(p);
    }*/
  }
}

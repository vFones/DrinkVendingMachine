package com.prog3.servlet.client.cor;

public class PaymentChain {
  RequestHandler chain;

  public PaymentChain(){
    buildChain();
  }

  private void buildChain(){
    chain = new KeyPayment(new CcPayment(new CashPayment(null)));
  }

  public void makeRequest(Payment p) {
    chain.handlePayment(p);
  }
}

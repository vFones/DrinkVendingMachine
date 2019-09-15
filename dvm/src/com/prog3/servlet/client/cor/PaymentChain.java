package com.prog3.servlet.client.cor;

/**
 * Payment chain is the creator for chain of responsibility, instead of doing that in main program.
 */
public class PaymentChain {
  /**
   * the abstract Chain.
   */
  ARequestHandler chain;

  /**
   * Instantiates a new Payment chain.
   */
  public PaymentChain(){
    buildChain();
  }

  /**
   * Private method buildChain(). Coded to set chain
   */
  private void buildChain(){
    chain = new KeyPayment(new CcPayment(new CashPayment(null)));
  }

  /**
   * Make request for payment check.
   * Start handle in chain.
   *
   * @param p as Payment bean
   */
  public void makeRequest(Payment p) {
    chain.handlePayment(p);
  }
}

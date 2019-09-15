package com.prog3.servlet.client.cor;

/**
 * abstract class for handle payment and istantiate succeros in chain
 */
abstract public class ARequestHandler {
  private ARequestHandler next;

  /**
   * Instantiates a new A request handler.
   *
   * @param successor the successor in Chain
   */
  public ARequestHandler(ARequestHandler successor) {
    this.next = successor;
  }

  /**
   * Handle payment.
   *
   * @param payment Java bean that need to be checked in chain
   */
  public void handlePayment(Payment payment) {
    if (next != null) {
      next.handlePayment(payment);
    }
  }
}

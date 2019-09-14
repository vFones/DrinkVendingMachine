package com.prog3.servlet.client.cor;

abstract public class ARequestHandler {
  private ARequestHandler next;

  public ARequestHandler(ARequestHandler successor) {
    this.next = successor;
  }

  public void handlePayment(Payment payment) {
    if (next != null) {
      next.handlePayment(payment);
    }
  }
}

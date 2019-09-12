package com.prog3.servlet.client.cor;

abstract public class RequestHandler {
  private RequestHandler next;

  public RequestHandler(RequestHandler successor) {
    this.next = successor;
  }

  public void handlePayment(Payment payment) {
    if (next != null) {
      next.handlePayment(payment);
    }
  }
}

package com.prog3.servlet.client.cor;

import com.prog3.hibernate.ormbean.Purchase;

public class Payment {
  public enum PaymentType{ KEY, CASH, CC }
  private PaymentType type;
  private Float coins;
  private boolean paid;
  private Purchase purchase;

  public Payment(){};

  public Payment(Float coins, boolean paid, Purchase purchase) {
    this.coins = coins;
    this.paid = paid;
    this.purchase = purchase;
  }

  public Float getCoins() {
    return coins;
  }

  public void setCoins(Float coins) {
    this.coins = coins;
  }

  public boolean isPaid() {
    return paid;
  }

  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  public PaymentType getType() {
    return type;
  }

  public void setType(PaymentType type) {
    this.type = type;
  }

  public Purchase getPurchase() {
    return purchase;
  }

  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }
}

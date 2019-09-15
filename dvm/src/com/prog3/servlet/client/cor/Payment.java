package com.prog3.servlet.client.cor;

import com.prog3.db.ormbean.Purchase;

/**
 *  Payment java bean
 */
public class Payment {
  private EPaymentType type;
  private Float coins;
  private boolean paid;
  private Purchase purchase;

  /**
   * Instantiates a new Payment.
   */
  public Payment(){};

  /**
   * Instantiates a new Payment.
   *
   * @param coins    Float inserted to check enough amount
   * @param paid     if paid (will be modified in CoR)
   * @param purchase Purchase bean for information gathering
   */
  public Payment(Float coins, boolean paid, Purchase purchase) {
    this.coins = coins;
    this.paid = paid;
    this.purchase = purchase;
  }

  /**
   * Gets coins.
   *
   * @return the coins
   */
  public Float getCoins() {
    return coins;
  }

  /**
   * Sets coins.
   *
   * @param coins the coins
   */
  public void setCoins(Float coins) {
    this.coins = coins;
  }

  /**
   * Is paid boolean.
   *
   * @return the boolean
   */
  public boolean isPaid() {
    return paid;
  }

  /**
   * Sets paid.
   *
   * @param paid the paid
   */
  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public EPaymentType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(EPaymentType type) {
    this.type = type;
  }

  /**
   * Gets purchase.
   *
   * @return the purchase
   */
  public Purchase getPurchase() {
    return purchase;
  }

  /**
   * Sets purchase.
   *
   * @param purchase the purchase
   */
  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }
}

package com.prog3.hibernate.ormbean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Purchase.java
 * This is a model class represents a purchase entity
 *
 * @author Vittorio Fones
 */
@Entity
@Table(name="purchase")
public class PurchaseBean {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="purchase_id")
  private int purchase_id;
  @Column(name="date", nullable = false)
  private Timestamp date;
  @OneToOne
  @JoinColumn(name="prod_id", nullable = false)
  private ProductBean productBean;
  @Column(name="cash", nullable = false)
  private boolean cash;
  @Column(name="credit_card", nullable = false)
  private boolean credit_card;
  @Column(name="cc_number")
  private String cc_number;
  @OneToOne
  @JoinColumn(name="id_key")
  private KeyBean keyBean;

  /**
   * Gets purchase id.
   *
   * @return the purchase id
   */
  public int getPurchase_id() {
    return purchase_id;
  }

  /**
   * Sets purchase id.
   *
   * @param purchase_id the purchase id
   */
  public void setPurchase_id(int purchase_id) {
    this.purchase_id = purchase_id;
  }

  /**
   * Sets date.
   *
   * @param date the date
   */
  public void setDate(Timestamp date) {
    this.date = date;
  }

  /**
   * Gets date.
   *
   * @return the date
   */
  public Timestamp getDate() {
    return date;
  }

  /**
   * Sets product bean.
   *
   * @param productBean the product bean
   */
  public void setProductBean(ProductBean productBean) {
    this.productBean = productBean;
  }

  /**
   * Gets product bean.
   *
   * @return the product bean
   */
  public ProductBean getProductBean() {
    return productBean;
  }

  /**
   * Sets cash.
   *
   * @param cash the cash
   */
  public void setCash(boolean cash) {
    this.cash = cash;
  }

  /**
   * Is cash boolean.
   *
   * @return the boolean
   */
  public boolean isCash() {
    return cash;
  }

  /**
   * Sets credit card.
   *
   * @param credit_card the credit card
   */
  public void setCredit_card(boolean credit_card) {
    this.credit_card = credit_card;
  }

  /**
   * Is credit card boolean.
   *
   * @return the boolean
   */
  public boolean isCredit_card() {
    return credit_card;
  }

  /**
   * Gets cc number.
   *
   * @return the cc number
   */
  public String getCc_number() {
    return cc_number;
  }

  /**
   * Sets cc number.
   *
   * @param cc_number the cc number
   */
  public void setCc_number(String cc_number) {
    this.cc_number = cc_number;
  }

  /**
   * Gets key bean.
   *
   * @return the key bean
   */
  public KeyBean getKeyBean() {
    return keyBean;
  }

  /**
   * Sets key bean.
   *
   * @param keyBean the key bean
   */
  public void setKeyBean(KeyBean keyBean) {
    this.keyBean = keyBean;
  }
}
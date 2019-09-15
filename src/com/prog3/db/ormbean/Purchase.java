package com.prog3.db.ormbean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Purchase.java
 * This is a model class represents a purchase entity
 *
 * @author Vittorio Fones
 */
@Entity
@Table(name="purchase")
public class Purchase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="purchase_id")
  private int purchase_id;

  @Column(name="date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @OneToOne
  @JoinColumn(name="prod_id", nullable = false)
  private Product product;

  @Column(name="cash", nullable = false)
  private boolean cash;

  @Column(name="cc_number")
  private String cc_number;

  @OneToOne
  @JoinColumn(name="id_key")
  private Key key;

  /**
   * Instantiates a new Purchase.
   */
  public Purchase() {
  }

  /**
   * Instantiates a new Purchase.
   *
   * @param date      the date
   * @param product   the product
   * @param cash      the cash
   * @param cc_number the cc number
   * @param key       the key
   */
  public Purchase(Date date, Product product, boolean cash, String cc_number, Key key) {
    this.date = date;
    this.product = product;
    this.cash = cash;
    this.cc_number = cc_number;
    this.key = key;
  }

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
  public Date getDate() {
    return date;
  }

  /**
   * Sets product bean.
   *
   * @param product the product bean
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * Gets product bean.
   *
   * @return the product bean
   */
  public Product getProduct() {
    return product;
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
  public Key getKey() {
    return key;
  }

  /**
   * Sets key bean.
   *
   * @param key the key bean
   */
  public void setKey(Key key) {
    this.key = key;
  }
}
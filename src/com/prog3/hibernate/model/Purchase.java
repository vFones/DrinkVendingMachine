package com.prog3.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Purchase.java
 * This is a model class represents a purchase entity
 * @author Vittorio Fones
 *
 */
@Entity
@Table(name="purchase")
public class Purchase{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "purchase_id")
  private int purchase_id;
  @Column(name="date", nullable = false)
  private Timestamp date;
  @OneToOne
  @JoinColumn(name = "prod_id", nullable = false)
  private Product product;
  @Column(name="cash", nullable = false)
  private boolean cash;
  @Column(name="credit_card", nullable = false)
  private boolean credit_card;
  @Column(name="cc_number")
  private String cc_number;
  @OneToOne
  @Column(name="id_key")
  private Key key;

  public Purchase(){}
  public Purchase(Timestamp date, Product product, boolean cash, boolean credit_card, String cc_number, Key key){
    super();
    this.date = date;
    this.product = product;
    this.cash = cash;
    this.credit_card = credit_card;
    this.cc_number = cc_number;
    this.key = key;
  }
  public Purchase(int purchase_id, Timestamp date, Product product, boolean cash, boolean credit_card, String cc_number, Key key){
    super();
    this.purchase_id = purchase_id;
    this.date = date;
    this.product = product;
    this.cash = cash;
    this.credit_card = credit_card;
    this.cc_number = cc_number;
    this.key = key;
  }

  public int getPurchase_id() {
    return purchase_id;
  }
  public void setPurchase_id(int purchase_id) {
    this.purchase_id = purchase_id;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }
  public Timestamp getDate() {
    return date;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
  public Product getProduct() {
    return product;
  }

  public void setCash(boolean cash) {
    this.cash = cash;
  }
  public boolean isCash() {
    return cash;
  }

  public void setCredit_card(boolean credit_card) {
    this.credit_card = credit_card;
  }
  public boolean isCredit_card() {
    return credit_card;
  }

  public String getCc_number() {
    return cc_number;
  }
  public void setCc_number(String cc_number) {
    this.cc_number = cc_number;
  }

  public Key getKey() {
    return key;
  }
  public void setKey(Key key) {
    this.key = key;
  }
}
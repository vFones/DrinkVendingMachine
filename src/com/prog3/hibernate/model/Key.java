package com.prog3.hibernate.model;

import javax.persistence.*;

/**
 * Key.java
 * This is a model class represents a Key entity
 * @author Vittorio Fones
 *
 */
@Entity
@Table(name="key")
public class Key{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_key")
  private int id_key;
  @Column(name="balance", nullable = false)
  private float balance;

  public Key(){}

  public Key(float balance) {
    super();
    this.balance = balance;
  }

  public Key(int id_key, float balance) {
    super();
    this.id_key = id_key;
    this.balance = balance;
  }

  public int getId_key() {
    return id_key;
  }
  public void setId_key(int id_key) {
    this.id_key = id_key;
  }

  public float getBalance() {
    return balance;
  }
  public void setBalance(float balance) {
    this.balance = balance;
  }
}
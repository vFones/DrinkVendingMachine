package com.prog3.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User.java
 * This is a model class represents a Person entity
 * @author Vittorio Fones
 *
 */
@Entity
@Table(name="person")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private int user_id;
  @Column(name="balance")
  private float balance;

  @ManyToMany(cascade = {
      CascadeType.ALL
  })
  @JoinTable(
      name = "purchase",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "prod_id")
  )
  private Set<Product> products = new HashSet<>(0);

  public User(){
  }

  public User(float balance, Set<Product> products) {
    super();
    this.balance = balance;
  }

  public User(int user_id, float balance, Set<Product> products) {
    super();
    this.user_id = user_id;
    this.balance = balance;
  }

  public int getUserId() {
    return user_id;
  }
  public void setUserId(int user_id) {
    this.user_id = user_id;
  }

  public float getBalance() {
    return balance;
  }
  public void setBalance(float balance) {
    this.balance = balance;
  }

  public void setProductList(Set<Product> productList) {
    this.products = productList;
  }
  public Set<Product> getProductList() {
    return products;
  }

}
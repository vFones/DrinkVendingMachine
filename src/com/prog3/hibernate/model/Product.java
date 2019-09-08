package com.prog3.hibernate.model;

import javax.persistence.*;

/**
 * Product.java
 * This is a model class represents a product entity
 * @author Vittorio Fones
 *
 */
@Entity
@Table(name="product")
public class Product {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="prod_id")
  private int prod_id;
  @Column(name="price", nullable = false)
  private float price;
  @Column(name="stock", nullable = false)
  private int stock;
  @Column(name="name", unique = true, nullable = false)
  private String name;

  public Product(){}

  public Product(float price, int stock, String name) {
    super();
    this.price = price;
    this.stock = stock;
    this.name = name;
  }

  public Product(int prod_id, float price, int stock, String name) {
    super();
    this.prod_id = prod_id;
    this.price = price;
    this.stock = stock;
    this.name = name;
  }

  public float getPrice() {
    return price;
  }
  public void setPrice(float price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getProd_id() {
    return prod_id;
  }
  public void setProd_id(int prod_id) {
    this.prod_id = prod_id;
  }
}
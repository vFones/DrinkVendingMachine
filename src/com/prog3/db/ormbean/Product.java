package com.prog3.db.ormbean;

import javax.persistence.*;

/**
 * Product.java
 * This is a model class represents a product entity
 *
 * @author Vittorio Fones
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
  private float stock;
  @Column(name="name", unique = true, nullable = false)
  private String name;

  /**
   * Gets price.
   *
   * @return the price
   */
  public float getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(float price) {
    this.price = price;
  }

  /**
   * Gets stock.
   *
   * @return the stock
   */
  public float getStock() {
    return stock;
  }

  /**
   * Sets stock.
   *
   * @param stock the stock
   */
  public void setStock(float stock) {
    this.stock = stock;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets prod id.
   *
   * @return the prod id
   */
  public int getProd_id() {
    return prod_id;
  }

  /**
   * Sets prod id.
   *
   * @param prod_id the prod id
   */
  public void setProd_id(int prod_id) {
    this.prod_id = prod_id;
  }
}
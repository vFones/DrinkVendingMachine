package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.Product;

import java.util.List;

/**
 * Product DAO implementation
 *
 * @author Vittorio Fones
 */
public class ProductDao extends GenericDao<Product> {
  private final String selectStarFromProduct = "from Product";

  @Override
  public void save(Product p) {
    super.save(p);
  }

  @Override
  public void remove(Product p) {
    super.remove(p);
  }

  @Override
  public void update(Product p) {
    super.update(p);
  }

  public List<Product> query(String s) {
    return super.query(s);
  }

  /**
   * Get all list.
   *
   * @return the list
   */
  public List<Product> getAll() {
    return super.query(selectStarFromProduct);
  }
}


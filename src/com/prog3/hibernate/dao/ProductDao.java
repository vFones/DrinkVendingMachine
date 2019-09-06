package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Product;

import java.util.List;

/**
 * Product DAO implementation
 * @author Vittorio Fones
 */
public class ProductDao extends GenericDao<Product>{
  @Override
  public void save(Product p) {
    super.save(p);
  }
  @Override
  public void delete(int id) {
    super.delete(id);
  }
  @Override
  public void update(Product p) {
    super.update(p);
  }
  public List<Product> getAll() {
    return super.getAll("from Product");
  }
}

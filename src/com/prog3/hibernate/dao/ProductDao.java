package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Product;

import java.util.List;

/**
 * Product DAO implementation
 * @author Vittorio Fones
 */
public class ProductDao extends GenericDao<Product>{
  private final String selectStarFromProduct = "from Product";

  @Override
  public void save(Product p) {
  }
  @Override
  public void delete(int id) {
  }
  @Override
  public void update(Product p) {
  }
  public List<Product> query(String s){
    return super.query(s);
  }
  public List<Product> getAll(){
    return super.query(selectStarFromProduct);
  }

  //intented for testing queries
  public static void main(String[]args) {
    ProductDao prod = new ProductDao();
    List<Product> dio = prod.getAll();
    for (Product u : dio) {
      System.out.println(u.getName());
    }
  }
}

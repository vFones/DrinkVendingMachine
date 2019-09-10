package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.ProductBean;

import java.util.List;

/**
 * Product DAO implementation
 *
 * @author Vittorio Fones
 */
public class ProductDao extends GenericDao<ProductBean>{
  private final String selectStarFromProduct = "from ProductBean";

  @Override
  public void save(ProductBean p) {
    super.save(p);
  }
  @Override
  public void remove(ProductBean p) {
    super.remove(p);
  }
  @Override
  public void update(ProductBean p) {
    super.update(p);
  }
  public List<ProductBean> query(String s){
    return super.query(s);
  }

  /**
   * Get all list.
   *
   * @return the list
   */
  public List<ProductBean> getAll(){
    return super.query(selectStarFromProduct);
  }

  //intented for testing queries
  /*public static void main(String[]args) {
    ProductDao prod = new ProductDao();
    List<ProductBean> dio = prod.getAll();
    for (ProductBean u : dio) {
      System.out.println(u.getName());
    }
  }*/
}

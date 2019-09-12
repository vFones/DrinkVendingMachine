package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.Purchase;

import java.util.List;

/**
 * The type Purchase dao.
 */
public class PurchaseDao extends GenericDao<Purchase>{
  /**
   * The constant selectStarFromPurchase.
   */
  final static String selectStarFromPurchase = "from Purchase";
  @Override
  public void save(Purchase p){
    super.save(p);
  }
  @Override
  public void remove(Purchase p) {
    super.remove(p);
  }
  @Override
  public void update(Purchase purchase) {
    super.update(purchase);
  }

  public List<Purchase> query(String s){
    return super.query(s);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Purchase> getAll() {
    return super.query(selectStarFromPurchase);
  }
}

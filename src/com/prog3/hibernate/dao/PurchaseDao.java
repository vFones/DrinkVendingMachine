package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.PurchaseBean;

import java.util.List;

/**
 * The type Purchase dao.
 */
public class PurchaseDao extends GenericDao<PurchaseBean>{
  /**
   * The constant selectStarFromPurchase.
   */
  final static String selectStarFromPurchase = "from PurchaseBean";
  @Override
  public void save(PurchaseBean p){
    super.save(p);
  }
  @Override
  public void remove(PurchaseBean p) {
    super.remove(p);
  }
  @Override
  public void update(PurchaseBean purchaseBean) {
    super.update(purchaseBean);
  }

  public List<PurchaseBean> query(String s){
    return super.query(s);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<PurchaseBean> getAll() {
    return super.query(selectStarFromPurchase);
  }
}

package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Purchase;

import java.util.List;

public class PurchaseDao extends GenericDao<Purchase>{
  final static String selectStarFromPurchase = "from Purchase";
  @Override
  public void save(Purchase p){
    super.save(p);
  }
  @Override
  public void delete(int id){super.delete(id);}
  @Override
  public void update(Purchase purchase) {
    super.update(purchase);
  }
  public List<Purchase> query(String s){
    return super.query(s);
  }
  public List<Purchase> getAll() {
    return super.query(selectStarFromPurchase);
  }
}

package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Purchase;

import java.util.List;

public class PurchaseDao extends GenericDao<Purchase>{
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
  public List<Purchase> getAll() {
    return super.getAll("from Purchase");
  }
}

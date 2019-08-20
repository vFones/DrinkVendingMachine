package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Product;
import com.prog3.hibernate.model.User;

import java.util.List;

/**
 * Product DAO implementation
 * @author Vittorio Fones
 */
public class ProductDao extends GenericDao<Product>{
  public void save(Product p) {
    super.save(p);
  }
  public void delete(int id) {
    super.delete(id);
  }
  public void update(Product p) {
    super.update(p);
  }
  public List<Product> getAll() {
    return super.getAll("from Product");
  }
}

/*public class UserDao{
  public static void main(String[]args){
    GenericDao<User> user = new GenericDao<User>();
    User toSave = new User();
    toSave.setUserId(5);
    toSave.setBalance(32.0F);
    //user.save(toSave);
    List<User> dio = user.getAll("from User");
    for (User u: dio) {
      System.out.println(u.getBalance());
    }
  }
}*/
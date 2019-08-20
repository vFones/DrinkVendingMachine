package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.User;

import java.util.List;

/**
 * UserDAO implementation
 * @author Vittorio Fones
 */
public class UserDao extends GenericDao<User>{
  public void save(User u) {
    super.save(u);
  }
  public void delete(int id) {
    super.delete(id);
  }
  public void update(User u) {
    super.update(u);
  }
  public List<User> getAll() {
    return super.getAll("from User");
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
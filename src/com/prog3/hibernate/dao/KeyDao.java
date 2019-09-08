package com.prog3.hibernate.dao;

import com.prog3.hibernate.model.Key;

import java.util.List;

/**
 * KeyDAO implementation
 * @author Vittorio Fones
 */
public class KeyDao extends GenericDao<Key>{
  final static String selectStarFrom = "from Key";

  @Override
  public void save(Key k) {
    super.save(k);
  }
  @Override
  public void delete(int id) {
    super.delete(id);
  }
  @Override
  public void update(Key k) {
    super.update(k);
  }

  public List<Key> query(String s){
    return super.query(s);
  }
  public List<Key> getAll() {
    return super.query(selectStarFrom);
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
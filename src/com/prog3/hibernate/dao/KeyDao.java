package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.KeyBean;

import java.util.List;

/**
 * KeyDAO implementation
 *
 * @author Vittorio Fones
 */
public class KeyDao extends GenericDao<KeyBean>{
  /**
   * The constant selectStarFrom.
   */
  final static String selectStarFrom = "from KeyBean";

  @Override
  public void save(KeyBean k) {
    super.save(k);
  }
  @Override
  public void remove(KeyBean k) {
    super.remove(k);
  }
  @Override
  public void update(KeyBean k) {
    super.update(k);
  }

  public List<KeyBean> query(String s){
    return super.query(s);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<KeyBean> getAll() {
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
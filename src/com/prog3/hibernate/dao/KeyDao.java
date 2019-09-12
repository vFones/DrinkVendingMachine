package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.Key;

import java.util.List;

/**
 * KeyDAO implementation
 *
 * @author Vittorio Fones
 */
public class KeyDao extends GenericDao<Key>{
  /**
   * The constant selectStarFrom.
   */
  private final static String selectStarFrom = "from Key";

  @Override
  public void save(Key k) {
    super.save(k);
  }
  @Override
  public void remove(Key k) {
    super.remove(k);
  }
  @Override
  public void update(Key k) {
    super.update(k);
  }

  public List<Key> query(String s){
    return super.query(s);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List getAll() {
    return super.query(selectStarFrom);
  }


}
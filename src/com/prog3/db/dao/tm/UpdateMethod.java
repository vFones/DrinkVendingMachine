package com.prog3.db.dao.tm;

import org.hibernate.Session;

/**
 * The type Update method.
 *
 * @param <T> the type parameter
 */
public class UpdateMethod<T> extends ACrudMethod<T> {
  private T t;

  /**
   * Instantiates a new Update method.
   *
   * @param t the t
   */
  public UpdateMethod(T t){
    this.t = t;
  }
  @Override
  public void dbOperations(Session session) {
    session.update(t);
  }
}

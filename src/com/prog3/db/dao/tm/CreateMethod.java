package com.prog3.db.dao.tm;

import org.hibernate.Session;

/**
 * The type Create method.
 *
 * @param <T> the type parameter
 */
public class CreateMethod<T> extends ACrudMethod<T> {
  private T t;

  /**
   * Instantiates a new Create method.
   *
   * @param t model
   */
  public CreateMethod(T t){
    this.t = t;
  }

  @Override
  public void dbOperations(Session session) {
    session.save(t);
  }

}

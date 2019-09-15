package com.prog3.db.dao.tm;

import org.hibernate.Session;

/**
 * The type Retrieve method.
 *
 * @param <T> the type parameter
 */
public class RetrieveMethod<T> extends ACrudMethod<T> {
  private String query;

  /**
   * Instantiates a new Retrieve method.
   *
   * @param query the query
   */
  public RetrieveMethod(String query) {
    this.query = query;
  }

  @Override
  public void dbOperations(Session session) {
    super.setList(session.createQuery(query).list());
  }

}

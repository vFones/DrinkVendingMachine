package com.prog3.db.dao.tm;

import org.hibernate.Session;

public class RetrieveMethod<T> extends CrudMethod<T> {
  private String query;

  public RetrieveMethod(String query) {
    this.query = query;
  }

  @Override
  public void dbOperations(Session session) {
    super.setList(session.createQuery(query).list());
  }

}

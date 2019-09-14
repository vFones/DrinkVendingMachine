package com.prog3.db.dao.tm;

import org.hibernate.Session;

public class UpdateMethod<T> extends ACrudMethod<T> {
  private T t;

  public UpdateMethod(T t){
    this.t = t;
  }
  @Override
  public void dbOperations(Session session) {
    session.update(t);
  }
}

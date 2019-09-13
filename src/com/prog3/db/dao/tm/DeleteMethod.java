package com.prog3.db.dao.tm;

import org.hibernate.Session;

public class DeleteMethod<T> extends CrudMethod<T> {
  private T t;

  public DeleteMethod(T t){
    this.t = t;
  }

  @Override
  public void dbOperations(Session session) {
    session.delete(t);
  }
}

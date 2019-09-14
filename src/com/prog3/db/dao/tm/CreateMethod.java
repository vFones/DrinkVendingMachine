package com.prog3.db.dao.tm;

import org.hibernate.Session;

public class CreateMethod<T> extends ACrudMethod<T> {
  private T t;

  public CreateMethod(T t){
    this.t = t;
  }

  @Override
  public void dbOperations(Session session) {
    session.save(t);
  }

}

package com.prog3.db.dao.tm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

abstract class CrudMethod<T> {
  private List<T> list;
  public abstract void dbOperations(Session session);

  public void setList(List<T> list) {
    this.list = list;
  }

  public List<T> getList() { return list;
  }
  public T getT() {
    if(list.size() >0 )
      return list.get(0);
    return null;
  }

  public void run(){
    Transaction transaction = null;
    Session session = null;
    try{
      Configuration configuration = new Configuration().configure();
      SessionFactory sessionFactory = configuration.buildSessionFactory();
      session = sessionFactory.openSession();
      transaction = session.beginTransaction();
      transaction.setTimeout(3);

      dbOperations(session);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
}
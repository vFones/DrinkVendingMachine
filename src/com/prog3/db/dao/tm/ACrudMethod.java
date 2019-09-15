package com.prog3.db.dao.tm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * The type Abstract crud method.
 *
 * @param <T> the type parameter
 */
abstract class ACrudMethod<T> {
  private List<T> list;

  /**
   * Db operations to implement
   *
   * @param session the session
   */
  public abstract void dbOperations(Session session);

  /**
   * Sets list.
   *
   * @param list the list
   */
  public void setList(List<T> list) {
    this.list = list;
  }

  /**
   * Gets list.
   *
   * @return the list
   */
  public List<T> getList() { return list;
  }

  /**
   * Gets the bean
   *
   * @return the the bean
   */
  public T getT() {
    if(list.size() >0 )
      return list.get(0);
    return null;
  }

  /**
   * Run hibernate configurations.
   */
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
      assert session != null;
      session.close();
    }
  }
}

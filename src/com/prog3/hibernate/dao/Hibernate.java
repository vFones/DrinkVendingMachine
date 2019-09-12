package com.prog3.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Create db connection every time need to perform a dbOperations
 *
 * @author Vittorio Fones
 */
public abstract class Hibernate {
  /**
   * Need to implement db operations
   *
   * @param session the session
   */
  public abstract void dbOperations(Session session);

  /**
   * Run.
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
    }catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }finally {
      session.close();
    }
  }
}

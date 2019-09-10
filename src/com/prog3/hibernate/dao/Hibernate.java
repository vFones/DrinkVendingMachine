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
    try{
      Configuration configuration = new Configuration().configure();
      SessionFactory sessionFactory = configuration.buildSessionFactory();
      Session session = sessionFactory.openSession();
      transaction = session.beginTransaction();

      dbOperations(session);

      transaction.commit();
      sessionFactory.close();

    }catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
}

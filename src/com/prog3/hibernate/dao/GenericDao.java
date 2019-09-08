package com.prog3.hibernate.dao;

import org.hibernate.Session;

import java.util.List;


/**
 * CRUD database operations
 * @author Vittorio Fones
 *
 */
public class GenericDao<T> {
  /**
   * Save model
   * @param t aka model
   */
  public void save( final T t ) {
    new Hibernate(){
      @Override
      public void dbOperations(Session session) {
        session.save(t);
      }
    }.run();
  }

  /**
   * Update
   * @param t aka model
   */
  public void update( final T t) {
    new Hibernate(){
      @Override
      public void dbOperations(Session session) {
        session.update(t);
      }
    }.run();
  }

  /**
   * Delete
   * @param id aka PK
   */
  public void delete(final int id) {
    new Hibernate(){
      @Override
      public void dbOperations(Session session) {
        Class model = session.get(Class.class, id);
        if (model != null) {
          session.delete(model);
          System.out.println("user is deleted");
        }
      }
    }.run();
  }
  /**
   * Query a model
   * @param query string
   * @return List <T>
   */
  public List<T> query(final String query) {
    final List[] list = new List[1];
    new Hibernate(){
      @Override
      public void dbOperations(Session session) {
        list[0] = session.createQuery(query).list();
      }
    }.run();
    return list[0];
  }
}

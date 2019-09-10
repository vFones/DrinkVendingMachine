package com.prog3.hibernate.dao;

import org.hibernate.Session;

import java.util.List;


/**
 * CRUD database operations
 *
 * @param <T> the type parameter
 * @author Vittorio Fones
 */
public class GenericDao<T> {
  /**
   * Save model
   *
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
   *
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
   *
   * @param t aka model
   */
  public void remove(T t) {
    new Hibernate(){
      @Override
      public void dbOperations(Session session) {
        session.remove(t);
      }
    }.run();
  }

  /**
   * Query a model
   *
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

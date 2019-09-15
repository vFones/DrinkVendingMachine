package com.prog3.db.dao;

import com.prog3.db.dao.tm.*;

import java.util.List;


/**
 * CRUD database operations
 *
 * @param <T> the Bean model parameter
 * @author Vittorio Fones
 */
public class GenericDao<T> {

  private String selectStarFrom;

  /**
   * Instantiates a new Generic dao.
   */
  public GenericDao(){};

  /**
   * Instantiates a new Generic dao with query S.
   *
   * @param s query String
   */
  public GenericDao(String s) {
    this.selectStarFrom = s;
  }

  /**
   * Save in db.
   *
   * @param t model
   */
  public void save(T t) {
    dbOperations<T> dbOperation = new dbOperations<T>(new CreateMethod<T>(t));
    dbOperation.run();
  }

  /**
   * Update in db
   *
   * @param t model
   */
  public void update(T t) {
    dbOperations<T> dbOperation = new dbOperations<T>(new UpdateMethod<T>(t));
    dbOperation.run();
  }

  /**
   * Make a query
   *
   * @param s string used for query
   * @return the list
   */
  public List<T> query(String s) {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(s));
    dbOperation.run();
    return dbOperation.getList();
  }

  /**
   * Query just one element
   *
   * @param s the string
   * @return the model type
   */
  public T queryBean(String s) {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(s));
    dbOperation.run();
    return dbOperation.getT();
  }

  /**
   * Gets all.
   *
   * @return List model
   */
  public List<T> getAll() {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(selectStarFrom));
    dbOperation.run();
    return dbOperation.getList();
  }
}

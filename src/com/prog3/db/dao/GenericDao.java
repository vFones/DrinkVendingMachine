package com.prog3.db.dao;

import com.prog3.db.dao.tm.*;

import java.util.List;


/**
 * CRUD database operations
 *
 * @param <T> the type parameter
 * @author Vittorio Fones
 */
public class GenericDao<T> {

  private String selectStarFrom;

  public GenericDao(){};
  public GenericDao(String s) {
    this.selectStarFrom = s;
  }

  public void save(T t) {
    dbOperations<T> dbOperation = new dbOperations<T>(new CreateMethod<T>(t));
    dbOperation.run();
  }

  public void update(T t) {
    dbOperations<T> dbOperation = new dbOperations<T>(new UpdateMethod<T>(t));
    dbOperation.run();
  }

  public List<T> query(String s) {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(s));
    dbOperation.run();
    return dbOperation.getList();
  }

  public T queryBean(String s) {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(s));
    dbOperation.run();
    return dbOperation.getT();
  }

  public List<T> getAll() {
    dbOperations<T> dbOperation = new dbOperations<T>(new RetrieveMethod<T>(selectStarFrom));
    dbOperation.run();
    return dbOperation.getList();
  }
}

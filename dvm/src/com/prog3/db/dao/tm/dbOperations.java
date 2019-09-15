package com.prog3.db.dao.tm;

import java.util.List;

/**
 * The type Db operations.
 *
 * @param <T> the type parameter
 */
public class dbOperations<T> {
  private ACrudMethod<T> crudMethod;

  /**
   * Instantiates a new Db operations.
   *
   * @param crudMethod the crud method
   */
  public dbOperations(ACrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  /**
   * Run.
   */
  public void run(){
    crudMethod.run();
  }

  /**
   * Change method.
   *
   * @param crudMethod the crud method
   */
  public void changeMethod(ACrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  /**
   * Get list
   *
   * @return the list
   */
  public List<T> getList(){
    return crudMethod.getList();
  }

  /**
   * Get the bean
   *
   * @return the t
   */
  public T getT(){
    return crudMethod.getT();
  }
}

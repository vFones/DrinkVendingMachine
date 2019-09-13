package com.prog3.db.dao.tm;

import java.util.List;

public class dbOperations<T> {
  private CrudMethod<T> crudMethod;

  public dbOperations(CrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  public void run(){
    crudMethod.run();
  }

  public void changeMethod(CrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  public List<T> getList(){
    return crudMethod.getList();
  }

  public T getT(){
    return crudMethod.getT();
  }
}

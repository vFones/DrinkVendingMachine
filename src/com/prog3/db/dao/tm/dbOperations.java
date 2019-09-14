package com.prog3.db.dao.tm;

import java.util.List;

public class dbOperations<T> {
  private ACrudMethod<T> crudMethod;

  public dbOperations(ACrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  public void run(){
    crudMethod.run();
  }

  public void changeMethod(ACrudMethod<T> crudMethod){
    this.crudMethod = crudMethod;
  }

  public List<T> getList(){
    return crudMethod.getList();
  }

  public T getT(){
    return crudMethod.getT();
  }
}

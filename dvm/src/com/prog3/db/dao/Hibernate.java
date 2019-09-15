package com.prog3.db.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
  private static SessionFactory factory;

  private Hibernate() {}

  public static synchronized SessionFactory getSessionFactory() {

    if (factory == null)
      factory = new Configuration().configure().buildSessionFactory();
    return factory;
  }
}
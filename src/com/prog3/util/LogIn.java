package com.prog3.util;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Admin;

import static com.prog3.util.Hash.md5Hash;

public class LogIn {
  public static Admin correctLogin(String email, String password){
    if(email != null && password != null) {
      Admin admin = new GenericDao<Admin>("from Admin").queryBean("from Admin where email='" + email +
          "' AND password='" + md5Hash(password) + "'");
      if (admin != null) {
        return admin;
      }
    }
    return null;
  }
}

package com.prog3.util;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Admin;

import static com.prog3.util.Hash.md5Hash;

/**
 * Class for log in utility.
 */
public class LogIn {
  /**
   * Check the correct email and password in DB using hibernate
   * and md5 algorithm
   *
   * @param email    email
   * @param password password
   * @return the admin user if success.
   */
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

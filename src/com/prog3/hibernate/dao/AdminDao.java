package com.prog3.hibernate.dao;

import com.prog3.hibernate.ormbean.Admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * The type Admin dao.
 */
public class AdminDao extends GenericDao<Admin> {
  /**
   * The constant selectStarFrom.
   */
  final static String selectStarFrom = "from AdminBean";

  /**
   * Md 5 hash string.
   *
   * @param s the s
   * @return the string
   */
  public String md5Hash(String s) {
    String hashword = null;
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
      md5.update(s.getBytes());
      BigInteger hash = new BigInteger(1, md5.digest());
      hashword = hash.toString(16);

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return hashword;
  }


  @Override
  public void save(Admin admin) {
    String hashedPasswd = md5Hash(admin.getPassword());
    admin.setPassword(hashedPasswd);
    super.save(admin);
  }

  @Override
  public void remove(Admin admin) {
    super.remove(admin);
  }

  @Override
  public void update(Admin admin) {
    String hashedPasswd = md5Hash(admin.getPassword());
    admin.setPassword(hashedPasswd);
    super.update(admin);
  }

  public List<Admin> query (String s){
    return super.query(s);
  }

  /**
   * Get all list.
   *
   * @return the list
   */
  public List<Admin> getAll(){
    return super.query(selectStarFrom);
  }

  /**
   * Main.
   *
   * @param args the args
   */
//intented for testing queries
  public static void main(String[]args) {
    AdminDao adminDao = new AdminDao();


    List<Admin> adminList = adminDao.query("from AdminBean where email='vittorio.fones@gmail.com' AND " +
        "password='"+ adminDao.md5Hash("passwordprogrammazione3") +"'");

    Admin admin = adminList.get(0);
    System.out.println(admin.getEmail());
  }
}

package com.prog3.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash util class
 */
public class Hash {
  /**
   * Create an hash with md5 algorithm.
   *
   * @param s string
   * @return hashed string
   */
  public static String md5Hash(String s) {
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
}

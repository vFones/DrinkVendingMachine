package com.prog3.util;

import java.math.BigDecimal;

public class Float2{
  /**
   * Round big decimal.
   *
   * @param d            the d
   * @param decimalPlace the decimal place
   * @return the big decimal
   */
  public static BigDecimal round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd;
  }
}
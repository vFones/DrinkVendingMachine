package com.prog3.util;

import java.math.BigDecimal;

/**
 * Class for float operations.
 */
public class Float2{
  /**
   * Round float to decimalPlace
   * es: 2.03124515 to 2.03 if decimalPlace is 2.
   *
   * @param d            the float number
   * @param decimalPlace the decimal place
   * @return rounded float
   */
  public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
  }
}
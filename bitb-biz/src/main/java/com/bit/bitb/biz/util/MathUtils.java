package com.bit.bitb.biz.util;

import java.math.BigDecimal;

public class MathUtils {
	/**
	 * 精确到小数点后8位.
	 */
	private static final int ACCURATE_BIT = 8;

	/**
	 * 精确浮点计算.-加法
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double add(Double d1, Double d2) {
		return add(String.valueOf(d1), String.valueOf(d2)).doubleValue();
	}
	
	public static Double sub(Double d1,Double d2){
		return sub(String.valueOf(d1), String.valueOf(d2)).doubleValue();
	}
	
	public static Double multWithAccurated(Double d1,Double d2){
		return multWithAccurated(String.valueOf(d1), String.valueOf(d2));
	}
	
	public static Double divideWithAccurated(Double divided, Double divide) {
		return divideWithAccurated(String.valueOf(divided), String.valueOf(divide));
	}

	/**
	 * 精确浮点计算.-加法
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal add(String d1, String d2) {
		BigDecimal sumBig = new BigDecimal(d1);
		BigDecimal newValue = new BigDecimal(d2);
		return sumBig.add(newValue);
	}

	/**
	 * 精确浮点计算.-减法
	 * 
	 * @param d1
	 *            被减数
	 * @param d2
	 *            减数
	 * @return
	 */
	public static BigDecimal sub(String d1, String d2) {
		BigDecimal v1 = new BigDecimal(d1);
		BigDecimal v2 = new BigDecimal(d2);
		return v1.subtract(v2);
	}

	/**
	 * 精确浮点计算.-乘法.
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static BigDecimal mult(String d1, String d2) {
		BigDecimal v1 = new BigDecimal(d1);
		BigDecimal v2 = new BigDecimal(d2);
		return v1.multiply(v2);
	}

	/**
	 * 精确浮点计算.-乘法.
	 * 
	 * <pre>
	 * 保留小数点后8位.
	 * 
	 * @param d1 
	 * @param d2
	 * @return
	 */
	public static Double multWithAccurated(String d1, String d2) {
		return mult(d1, d2).setScale(ACCURATE_BIT, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	public static void main(String[] args) {
		System.out.println(mult("0.000235", "0.0002") + "");
		System.out.println(multWithAccurated("0.000235", "0.0002") + "");
	}

	public static BigDecimal divide(String divided, String divide) {
		BigDecimal divideVal = new BigDecimal(divide);
		BigDecimal dividedVal = new BigDecimal(divided);
		return dividedVal.divide(divideVal);
	}

	/**
	 * 精确浮点计算.-除法
	 * 
	 * <pre>
	 * 精度为5.防止小数点溢出.
	 * 1000/12=83.33333333.....
	 * 
	 * @param divide 除数
	 * @param divided 被除数
	 * @return
	 */
	public static Double divideWithAccurated(String divided, String divide) {
		return divide(divided, divide).setScale(ACCURATE_BIT,
				BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

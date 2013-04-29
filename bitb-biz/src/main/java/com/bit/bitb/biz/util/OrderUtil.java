package com.bit.bitb.biz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtil {

	public static String genereateOrderNumberString() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyMMddhhmmss");
		String dateString = sdFormat.format(new Date());
		int randomInt = (int) (Math.random() * 100);
		return dateString.concat(String.valueOf(randomInt));
	}
}

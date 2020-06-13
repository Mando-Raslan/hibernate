package com.mohamed.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	
	public static String getStringDate(Date date) {

		return formatter.format(date);

	}

	public static Date getDate(String date) throws Exception {

		Date oldDate = formatter.parse(date);
		Date newDate = formatter.parse(formatter.format(oldDate));
		System.out.println(newDate);
		return newDate;

	}
	
}

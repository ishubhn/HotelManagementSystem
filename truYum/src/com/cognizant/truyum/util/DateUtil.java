package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) throws ParseException {
//		@SuppressWarnings("deprecation")
//		Date date_in = new Date(date) ;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");		//YYYY
		return df.parse(date);
	}
}

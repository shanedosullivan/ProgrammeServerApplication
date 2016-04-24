package com.programme.server.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {

	public static Date convertDateToString(String dateString, String datePattern){
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
}

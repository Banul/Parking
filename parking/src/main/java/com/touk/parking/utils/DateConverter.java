package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	public static Date convertDate(String dateString)  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date parsedDate = sdf.parse(dateString);
			return parsedDate;

		} catch (ParseException e) {

			return null;
		}
	}

}

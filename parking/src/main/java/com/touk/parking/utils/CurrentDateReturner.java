package com.touk.parking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateReturner {

	public static Date returnCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateString = formatter.format(date);
		Date currFormatedDate = DateConverter.convertDate(dateString);
		return currFormatedDate;
	}
}

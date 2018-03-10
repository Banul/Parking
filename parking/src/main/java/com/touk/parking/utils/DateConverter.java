package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.touk.parking.constans.ConstansHolder;

public class DateConverter {

	public static Date convertDate(String dateString) throws ParseException  {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstansHolder.DATE_FORMAT);
		Date parsedDate = sdf.parse(dateString);
		return parsedDate;
	}

}

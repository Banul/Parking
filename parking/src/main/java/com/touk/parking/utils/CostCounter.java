package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class CostCounter {
	
	private final int MILISECONDS_TO_HOUR = 3600*1000;

	public double getCost(String dateStart, String dateStop)  {
		double differance = countDifferanceBetweenDates(dateStart, dateStop);
		
		
		return 0;
	}
	
	private double countDifferanceBetweenDates(String dateStart, String dateStop) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date parsedDateStart = sdf.parse(dateStart);
			Date parsedDateEnd = sdf.parse(dateStop);
			double hoursDiff = ((parsedDateEnd.getTime() - parsedDateStart.getTime())/this.MILISECONDS_TO_HOUR);
			if (hoursDiff > 0)
				return hoursDiff + 1; //later parsing to int, so it will round to lower number, that's why +1
			else 
				return 0; 
				

		} catch (ParseException e) {
			return -1;

		}
		
	}

}

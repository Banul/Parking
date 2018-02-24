package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class CostCounter {
	
	private final int MILISECONDS_TO_HOUR = 3600*1000;
	private final double VIP_PRICE_FACTOR = 1.5;
	private final double REGULAR_PRICE_FACTOR = 2; 
	private final double VIP_SECOND_HOUR_PRICE = 2;

	public double getCost(String dateStart, String dateStop, boolean isVip)  {
		int differance = countDifferanceBetweenDates(dateStart, dateStop);
		double cost = countCost(differance, isVip);
		
		
		return cost;
	}
	
	private int countDifferanceBetweenDates(String dateStart, String dateStop) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date parsedDateStart = sdf.parse(dateStart);
			Date parsedDateEnd = sdf.parse(dateStop);
			double hoursDiff = ((parsedDateEnd.getTime() - parsedDateStart.getTime())/this.MILISECONDS_TO_HOUR);
			if (hoursDiff > 0)
				return (int) hoursDiff + 1; //parsing to int, so it will round to lower number, that's why +1
			else 
				return 0; 
				

		} catch (ParseException e) {
			return -1;

		}
	}
	
	private double countCost(int differance, boolean isVip) {
		double cost;
		if (isVip == false) 
			// sum of geometric series formula
			 cost = (1-Math.pow(REGULAR_PRICE_FACTOR, differance)) / ((1 - REGULAR_PRICE_FACTOR));
		else
			 cost = (1- VIP_SECOND_HOUR_PRICE * Math.pow(VIP_PRICE_FACTOR, differance - 1)) / ((1 - VIP_PRICE_FACTOR));
		
		return cost;
	}


}

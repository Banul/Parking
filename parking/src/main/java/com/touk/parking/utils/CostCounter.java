package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class CostCounter {

	private final int MILISECONDS_TO_HOUR = 3600 * 1000;
	private final double VIP_PRICE_FACTOR = 1.5;
	private final double REGULAR_PRICE_FACTOR = 2;
	private final double VIP_SECOND_HOUR_PRICE = 2;

	public double getCost(String dateStart, String dateStop, boolean isVip) {
		int differance = countDifferanceBetweenDates(dateStart, dateStop);
		double cost = countCost(differance, isVip);

		return cost;
	}

	private int countDifferanceBetweenDates(String dateStart, String dateStop) {
		Date parsedDateStart = DateConverter.convertDate(dateStart);
		Date parsedDateEnd = DateConverter.convertDate(dateStop);
		double milisecondsDiff = ((parsedDateEnd.getTime() - parsedDateStart.getTime()));
		if (milisecondsDiff > 0)
			return (int) (milisecondsDiff / MILISECONDS_TO_HOUR) + 1; // parsing to int, so it will round to lower
																		// number, that's why +1
		else
			return 0;

	}

	private double countCost(int differance, boolean isVip) {
		double cost;
		if (isVip == false)
			// sum of geometric series formula
			cost = (1 - Math.pow(REGULAR_PRICE_FACTOR, differance)) / ((1 - REGULAR_PRICE_FACTOR));
		else if (differance > 1)
			cost = VIP_SECOND_HOUR_PRICE * (1 - Math.pow(VIP_PRICE_FACTOR, differance - 1)) / ((1 - VIP_PRICE_FACTOR));
		else
			cost = 0;

		return cost;
	}

}

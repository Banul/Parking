package com.touk.parking.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CostCounter {

	private final int MILISECONDS_TO_HOUR = 3600 * 1000;
	private final double VIP_PRICE_FACTOR = 1.5;
	private final double REGULAR_PRICE_FACTOR = 2;
	private final double VIP_SECOND_HOUR_PRICE = 2;

	public BigDecimal getCost(Date dateStart, LocalDateTime currentDate, boolean isVip, boolean isMeterActive) {
		BigDecimal cost = new BigDecimal("0.00");
		if (isMeterActive) {
			int differance = countDifferanceBetweenDates(dateStart, currentDate);
			cost = countCost(differance, isVip);
		}

		return cost.setScale(2, RoundingMode.HALF_EVEN);
	}

	private int countDifferanceBetweenDates(Date dateStart, LocalDateTime currentDate) {
		LocalDateTime ldt = LocalDateTime.ofInstant(dateStart.toInstant(), ZoneId.systemDefault());

		long milisecondsDiff = Duration.between(ldt, currentDate).toMillis();
		return (int) (milisecondsDiff / MILISECONDS_TO_HOUR) + 1; // parsing to int, so it will round to lower
																	// number, that's why +1

	}

	private BigDecimal countCost(int differance, boolean isVip) {
		double cost;
		if (isVip == false)
			// sum of geometric series formula
			cost = (1 - Math.pow(REGULAR_PRICE_FACTOR, differance)) / ((1 - REGULAR_PRICE_FACTOR));
		else if (differance > 1)
			cost = VIP_SECOND_HOUR_PRICE * (1 - Math.pow(VIP_PRICE_FACTOR, differance - 1)) / ((1 - VIP_PRICE_FACTOR));
		else
			cost = 0;

		return BigDecimal.valueOf(cost);
	}

}

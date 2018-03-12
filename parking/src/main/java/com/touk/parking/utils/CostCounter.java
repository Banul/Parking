package com.touk.parking.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CostCounter {

	private final int MILISECONDS_TO_HOUR = 3600 * 1000;
	private final BigDecimal VIP_PRICE_FACTOR = new BigDecimal ("1.5");
	private final BigDecimal REGULAR_PRICE_FACTOR = new BigDecimal ("2");
	private final BigDecimal VIP_SECOND_HOUR_PRICE = new BigDecimal ("2");

	public BigDecimal getCost(Date dateStart, LocalDateTime currentDate, boolean isVip, boolean isMeterActive) {
		BigDecimal cost = BigDecimal.ZERO;
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
		
		BigDecimal costCounter;
		BigDecimal costDenominator;
		BigDecimal cost;
		
		if (isVip == false) {
			// sum of geometric series formula
			costCounter = (BigDecimal.ONE.subtract(REGULAR_PRICE_FACTOR.pow(differance)));
			costDenominator =  BigDecimal.ONE.subtract(REGULAR_PRICE_FACTOR);
			cost = costCounter.divide(costDenominator);
		}
			
		else if (differance > 1) {
			costCounter = (BigDecimal.ONE.subtract(VIP_PRICE_FACTOR.pow(differance-1)));
			costDenominator = BigDecimal.ONE.subtract(VIP_PRICE_FACTOR);
			cost = VIP_SECOND_HOUR_PRICE.multiply(costCounter.divide(costDenominator));
		}
		else
			cost = BigDecimal.ZERO;

		return cost;
	}

}

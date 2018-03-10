package com.touk.parking.utils;

import java.time.LocalDateTime;

public class CurrentDateReturner {

	public static LocalDateTime returnCurrentDate() {
		LocalDateTime date = LocalDateTime.now();
		return date;
	}
}

package com.touk.parking.utils;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;

public class DateConverterTest {

	Calendar calendar = GregorianCalendar.getInstance();

	@Test
	public void testDateConverter() {
		String[] datesToTest = createDatesToTest();
		Date[] expectedDates = createExpectedDates();

		for (int i = 0; i < datesToTest.length; i++) {
			assertTrue((expectedDates[i].getTime() - DateConverter.convertDate(datesToTest[i]).getTime()) == 0);
		}

	}

	private String[] createDatesToTest() {
		String[] datesToTest = new String[] { "2010-10-10 00:00:00", "2020-12-12 01:20:00", "2018-10-12 10:09:01" };
		return datesToTest;
	}

	private Date[] createExpectedDates() {
		Calendar calendarFirstDate = new GregorianCalendar(2010, Calendar.OCTOBER, 10, 0, 0, 0);
		Date firstDate = calendarFirstDate.getTime();

		Calendar calendarSecondDate = new GregorianCalendar(2020, Calendar.DECEMBER, 12, 1, 20, 0);
		Date secondDate = calendarSecondDate.getTime();

		Calendar calendarThirdDate = new GregorianCalendar(2018, Calendar.OCTOBER, 12, 10, 9, 1);
		Date thirdDate = calendarThirdDate.getTime();

		Date[] datesArrayToTest = new Date[] { firstDate, secondDate, thirdDate };
		return datesArrayToTest;
	}
}

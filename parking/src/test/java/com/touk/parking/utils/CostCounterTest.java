package com.touk.parking.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.touk.parking.utils.CostCounter;

public class CostCounterTest {

	private CostCounter counter = new CostCounter();
	private double result;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void testCostCountingMethodForAVipDriver_meterEnabled() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], true, true);
			assertEquals(createExpectedResultsForVipDriver()[i], result, 0);
		}
	}

	@Test
	public void testCostCountingMethodForARegularDriver_meterEnabled() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false,
					true);
			assertEquals(createExpectedResultsForRegularDriver()[i], result, 0);

		}
	}

	@Test
	public void testCostCountingMethodForDriver_meterDisabled() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false, false);
			assertEquals(createExpectedResultsWhenMeterIsDisabled()[i], result, 0);

		}
	}

	private Date[] createStartMeterTestScenarios() {
		Date[] startMeterTestScenarios = new Date[] { DateConverter.convertDate("2017-10-10 00:00:00"),
				DateConverter.convertDate("2017-11-12 00:00:00") };
		return startMeterTestScenarios;
	}

	private Date[] createStopMeterTestScenarios() {
		Date[] stopMeterTestScenarios = new Date[] { DateConverter.convertDate("2017-10-10 00:02:30"),
				DateConverter.convertDate("2017-11-12 05:30:00") };
		return stopMeterTestScenarios;
	}

	private double[] createExpectedResultsForVipDriver() {
		double[] expectedResultsVip = new double[] { 0, 26.375, 0 };
		return expectedResultsVip;
	}

	private double[] createExpectedResultsForRegularDriver() {
		double[] expectedResultsRegular = new double[] { 1, 63 };
		return expectedResultsRegular;
	}
	
	private double[] createExpectedResultsWhenMeterIsDisabled() {
		double[] expectedResultsDisabledMeter = new double[] {0,0,0};
		return expectedResultsDisabledMeter;
	}

}

package com.touk.parking.controller.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import com.touk.parking.utils.CostCounter;

public class CostCounterTest {


	private CostCounter counter = new CostCounter();
	private double result;

	@Test
	public void testCostCountingMethodForAVipDriver() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], true);
			assertEquals(createExpectedResultsForVipDriver()[i], result, 0);
		}
	}

	@Test
	public void testCostCountingMethodForARegularDriver() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false);
			assertEquals(createExpectedResultsForRegularDriver()[i], result, 0);
		}
	}

	private String[] createStartMeterTestScenarios() {
		String[] startMeterTestScenarios = new String[] { "2017-10-10 00:00:00", "2017-11-12 00:00:00",
				"2018-01-01 10:00:00" };
		return startMeterTestScenarios;
	}

	private String[] createStopMeterTestScenarios() {
		String[] stopMeterTestScenarios = new String[] { "2017-10-10 00:02:30", "2017-11-12 05:30:00",
		"2018-01-01 10:00:00" };
		return stopMeterTestScenarios;
	}

	private double[] createExpectedResultsForVipDriver() {
		double[] expectedResultsVip = new double[] { 0, 26.375, 0 };
		return expectedResultsVip;
	}

	private double[] createExpectedResultsForRegularDriver() {
		double[] expectedResultsRegular = new double[] { 1, 63, 0 };
		return expectedResultsRegular;
	}

}

package com.touk.parking.controller.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import com.touk.parking.utils.CostCounter;

public class CostCounterTest {

	private String[] startMeterTestScenarios = new String[] { "2017-10-10 00:00:00", "2017-11-12 00:00:00",
			"2018-01-01 10:00:00" };
	private String[] stopMeterTestScenarios = new String[] { "2017-10-10 00:02:30", "2017-11-12 05:30:00",
			"2018-01-01 10:00:00" };
	private double[] expectedResultsVipTrue = new double[] { 0, 26.375, 0 };
	private double[] expectedResultsVipFalse = new double[] { 1, 63, 0 };
	private CostCounter counter = new CostCounter();
	private double result;


	
	@Test
	public void testCostCountingMethodForAVipDriver() {
		for (int i = 0; i < startMeterTestScenarios.length; i++) {
		    result = counter.getCost(startMeterTestScenarios[i], stopMeterTestScenarios[i], true);
			assertEquals(expectedResultsVipTrue[i], result, 0);
		}
	}
	
	@Test
	public void testCostCountingMethodForARegularDriver() {
		for (int i = 0; i < startMeterTestScenarios.length; i++) {
		    result = counter.getCost(startMeterTestScenarios[i], stopMeterTestScenarios[i], false);
			assertEquals(expectedResultsVipFalse[i], result, 0);
		}
	}
	
}

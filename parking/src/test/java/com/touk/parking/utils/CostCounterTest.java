package com.touk.parking.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.touk.parking.model.MoneyModel;
import com.touk.parking.utils.CostCounter;

public class CostCounterTest {

	private CostCounter counter = new CostCounter();
	private BigDecimal result;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void testCostCountingMethodForAVipDriver_meterEnabled() {		
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], true, true);
			assertEquals(createExpectedResultsForVipDriver()[i].getAmount(), result);
		}
	}

	@Test
	public void testCostCountingMethodForARegularDriver_meterEnabled() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false,
					true);
			assertEquals(createExpectedResultsForRegularDriver()[i].getAmount(), result);

		}
	}

	@Test
	public void testCostCountingMethodForDriver_meterDisabled() {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false,
					false);
			assertEquals(createExpectedResultsWhenMeterIsDisabled()[i].getAmount(), result);

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

	private MoneyModel[] createExpectedResultsForVipDriver() {
		MoneyModel[] expectedResultsVip = new MoneyModel[] {MoneyModel.pln(new BigDecimal("0.00")), MoneyModel.pln (new BigDecimal ("26.38")) };
		return expectedResultsVip;
	}

	private MoneyModel[] createExpectedResultsForRegularDriver() {
		MoneyModel[] expectedResultsRegular = new MoneyModel[] {MoneyModel.pln(new BigDecimal ("1.00")), MoneyModel.pln(new BigDecimal("63.00"))};
		return expectedResultsRegular;
	}

	private MoneyModel[] createExpectedResultsWhenMeterIsDisabled() {
		MoneyModel[] expectedResultsDisabledMeter = new MoneyModel[] {MoneyModel.pln(new BigDecimal("0.00")), MoneyModel.pln(new BigDecimal("0.00")), MoneyModel.pln(new BigDecimal("0.00")) };
		return expectedResultsDisabledMeter;
	}

}

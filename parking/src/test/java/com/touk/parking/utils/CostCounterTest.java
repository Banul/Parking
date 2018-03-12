package com.touk.parking.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import com.touk.parking.constans.ConstansHolder;
import com.touk.parking.model.MoneyModel;
import com.touk.parking.utils.CostCounter;

public class CostCounterTest {
	
	private DateConverter dateConverter = new DateConverter();
	private CostCounter counter = new CostCounter();
	private BigDecimal result;
	SimpleDateFormat dateFormat = new SimpleDateFormat(ConstansHolder.DATE_FORMAT);

	@Test
	public void testCostCountingMethodForAVipDriver_meterEnabled() throws ParseException {		
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], true, true);
			assertEquals(createExpectedResultsForVipDriver()[i].getAmount(), result);
		}
	}

	@Test
	public void testCostCountingMethodForARegularDriver_meterEnabled() throws ParseException {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false,
					true);
			assertEquals(createExpectedResultsForRegularDriver()[i].getAmount(), result);

		}
	}

	@Test
	public void testCostCountingMethodForDriver_meterDisabled() throws ParseException {
		for (int i = 0; i < createStartMeterTestScenarios().length; i++) {
			result = counter.getCost(createStartMeterTestScenarios()[i], createStopMeterTestScenarios()[i], false,
					false);
			assertEquals(createExpectedResultsWhenMeterIsDisabled()[i].getAmount(), result);

		}
	}

	private Date[] createStartMeterTestScenarios() throws ParseException {
		Date[] startMeterTestScenarios = new Date[] { dateConverter.convertDate("2017-10-10 00:00:00"),
				dateConverter.convertDate("2017-11-12 00:00:00") };
		return startMeterTestScenarios;
	}

	private LocalDateTime[] createStopMeterTestScenarios() {
		LocalDateTime[] stopMeterTestScenarios = new LocalDateTime[] 
				{LocalDateTime.of( 2017, Month.OCTOBER, 10, 0, 2, 30), LocalDateTime.of(2017,Month.NOVEMBER,12,5,30,0)};
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

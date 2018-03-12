package com.touk.parking.serviceImpl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.CostDriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;
import com.touk.parking.model.MoneyModel;
import com.touk.parking.service.DriverService;
import com.touk.parking.utils.CostCounter;
import com.touk.parking.utils.CurrentDateReturner;
import com.touk.parking.utils.DateConverter;

@Service
@Primary
public class DriverServiceImpl implements DriverService {

	private final String DATABASE_COLUMN_NAME_STOP_TIME = "meterLastTimeStop";
	private final String DATABASE_COLUMN_NAME_START_TIME = "meterLastTimeStart";

	@Autowired
	@Qualifier("dateConverter")
	private DateConverter dateConverter;

	@Autowired
	DriverDao driverDao;

	public FullDriverModel getDriverDataById(int id) {
		return driverDao.getDriverDataById(id);
	}

	@Transactional
	public void updateDriverDataStopMeter(DriverModelUpdateMeterState driverUpdate) throws ParseException {
		driverUpdate.setMeterActive(false);
		driverDao.updateDriverData(driverUpdate, DATABASE_COLUMN_NAME_STOP_TIME);

	}

	@Transactional
	public void updateDriverDataStartMeter(DriverModelUpdateMeterState driverUpdate) throws ParseException {
		driverUpdate.setMeterActive(true);
		driverDao.updateDriverData(driverUpdate, DATABASE_COLUMN_NAME_START_TIME);
	}

	public CostDriverModel createModelForDriver(int pesel) throws ParseException {

		FullDriverModel driverModel = driverDao.getMeterTime(pesel);
		CostDriverModel costDriverModel;

		boolean isMeterActive = driverModel.isMeterActive();
		Date meterStartDate = dateConverter.convertDate(driverModel.getMeterLastTimeStart());
		LocalDateTime currentDate = CurrentDateReturner.returnCurrentDate();
		boolean isVip = driverModel.isVip();
		CostCounter counter = new CostCounter();
		BigDecimal cost = counter.getCost(meterStartDate, currentDate, isVip, isMeterActive);
		MoneyModel moneyToPay = MoneyModel.pln(cost);
		costDriverModel = new CostDriverModel(moneyToPay, isMeterActive);

		return costDriverModel;
	}

}

package com.touk.parking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.CostDriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;
import com.touk.parking.service.DriverService;
import com.touk.parking.utils.CostCounter;

@Service
public class DriverServiceImpl implements DriverService {

	private final String DATABASE_COLUMN_NAME_STOP_TIME = "meterLastTimeStop";
	private final String DATABASE_COLUMN_NAME_START_TIME = "meterLastTimeStart";

	@Autowired
	DriverDao driverDao;

	public FullDriverModel getDriverDataById(int id) {
		return driverDao.getDriverDataById(id);
	}

	public void updateDriverDataStopMeter(DriverModelUpdateMeterState driverUpdate) {

		driverUpdate.setMeterActive(false);
		driverDao.updateDriverData(driverUpdate, DATABASE_COLUMN_NAME_STOP_TIME);

	}

	public void updateDriverDataStartMeter(DriverModelUpdateMeterState driverUpdate) {

		driverUpdate.setMeterActive(true);
		driverDao.updateDriverData(driverUpdate, DATABASE_COLUMN_NAME_START_TIME);
	}

	public CostDriverModel createModelForDriver(int pesel) {
		FullDriverModel driverModel = driverDao.getMeterLastStartAndStopTime(pesel);
		CostDriverModel costDriverModel;
		
		try {
		boolean isMeterActive = driverModel.isMeterActive();
		String meterStart = driverModel.getMeterLastTimeStart();
		String meterStop = driverModel.getMeterLastTimeStop();
		boolean isVip = driverModel.isVip();
		CostCounter counter = new CostCounter();
		double cost = counter.getCost(meterStart, meterStop, isVip);
		costDriverModel = new CostDriverModel(cost, isMeterActive);
		}
		
		catch(Exception e) {
			costDriverModel = null;
		}

		return costDriverModel;
	}

}

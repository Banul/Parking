package com.touk.parking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.CostModel;
import com.touk.parking.model.DriverModel;
import com.touk.parking.service.DriverService;
import com.touk.parking.utils.CostCounter;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDao driverDao;

	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber) {
		return driverDao.getDriverDataByVehicleNumber(vehicleNumber);
	}

	public DriverModel getDriverDataById(int id) {
		return driverDao.getDriverDataById(id);
	}

	public CostModel getCost (int pesel) {
		DriverModel driverModel = driverDao.getMeterLastStartAndStopTime(pesel);
		String meterStart = driverModel.getMeterLastTimeStart();
		String meterStop = driverModel.getMeterLastTimeStop();
		CostCounter counter = new CostCounter();
		double cost = counter.getCost(meterStart, meterStop);
		CostModel costModel = new CostModel(cost);
		
		return costModel;
		
	}

}

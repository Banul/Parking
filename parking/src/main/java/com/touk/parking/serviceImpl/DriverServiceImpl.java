package com.touk.parking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.DriverModel;
import com.touk.parking.service.DriverService;

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

	public DriverModel getDriverDataByVehicleId(String vehicleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}

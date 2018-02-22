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

	public DriverModel getDriverData(int id) {
		return driverDao.getDriverData(id);
	}

}

package com.touk.parking.dao;

import java.util.List;

import com.touk.parking.model.DriverModel;

public interface DriverDao {

	public DriverModel getDriverDataById(int id);
	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber);
	public List<DriverModel> getMeterLastStartAndStopTime(int id);
}

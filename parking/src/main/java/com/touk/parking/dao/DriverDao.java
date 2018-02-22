package com.touk.parking.dao;

import com.touk.parking.model.DriverModel;

public interface DriverDao {

	public DriverModel getDriverDataById(int id);
	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber);
}

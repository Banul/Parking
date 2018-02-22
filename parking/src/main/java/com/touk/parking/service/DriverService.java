package com.touk.parking.service;

import com.touk.parking.model.DriverModel;

public interface DriverService {
	
	public DriverModel getDriverDataById(int id);
	public DriverModel getDriverDataByVehicleNumber (String vehicleNumber);

}

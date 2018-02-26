package com.touk.parking.dao;

import java.util.List;

import com.touk.parking.model.DriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;

public interface DriverDao {

	public DriverModel getDriverDataById(int id);
	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber);
	public DriverModel getMeterLastStartAndStopTime(int pesel);
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate);
}


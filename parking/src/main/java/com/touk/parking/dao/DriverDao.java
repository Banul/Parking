package com.touk.parking.dao;

import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

public interface DriverDao {

	public FullDriverModel getDriverDataById(int id);
	public FullDriverModel getMeterTime(int pesel);
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate);
}


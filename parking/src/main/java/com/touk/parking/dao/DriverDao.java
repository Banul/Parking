package com.touk.parking.dao;

import java.util.List;

import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

public interface DriverDao {

	public FullDriverModel getDriverDataById(int id);
	public FullDriverModel getMeterLastStartAndStopTime(int pesel);
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate);
}


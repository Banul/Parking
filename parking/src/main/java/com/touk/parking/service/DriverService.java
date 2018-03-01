package com.touk.parking.service;

import com.touk.parking.model.CostDriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

public interface DriverService {
	
	public FullDriverModel getDriverDataById(int id);
	public CostDriverModel createModelForDriver(int pesel);
	public void updateDriverDataStopMeter(DriverModelUpdateMeterState driverUpdate);
	public void updateDriverDataStartMeter(DriverModelUpdateMeterState driverUpdate);



}

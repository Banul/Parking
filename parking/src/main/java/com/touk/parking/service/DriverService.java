package com.touk.parking.service;

import java.util.List;

import com.touk.parking.model.CostModel;
import com.touk.parking.model.DriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;

public interface DriverService {
	
	public DriverModel getDriverDataById(int id);
	public DriverModel getDriverDataByVehicleNumber (String vehicleNumber);
	public CostModel getCost(int pesel);
	public void updateDriverDataStopMeter(DriverModelUpdateMeterState driverUpdate);
	public void updateDriverDataStartMeter(DriverModelUpdateMeterState driverUpdate);



}

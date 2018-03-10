package com.touk.parking.service;

import java.text.ParseException;

import com.touk.parking.model.CostDriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

public interface DriverService {

	public FullDriverModel getDriverDataById(int id);

	public CostDriverModel createModelForDriver(int pesel) throws ParseException;

	public void updateDriverDataStopMeter(DriverModelUpdateMeterState driverUpdate) throws ParseException;

	public void updateDriverDataStartMeter(DriverModelUpdateMeterState driverUpdate) throws ParseException;

}

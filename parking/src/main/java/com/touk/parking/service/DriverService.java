package com.touk.parking.service;

import org.springframework.stereotype.Service;

import com.touk.parking.model.DriverModel;

@Service
public interface DriverService {
	
	public DriverModel getDriverData(int id);

}

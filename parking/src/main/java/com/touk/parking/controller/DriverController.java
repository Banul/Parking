package com.touk.parking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touk.parking.model.DriverModel;
import com.touk.parking.service.DriverService;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

	@Autowired
	DriverService driverService;

	@RequestMapping(value = "id/{id}")
	public DriverModel getDriverDataById(@PathVariable int id) {

		return driverService.getDriverDataById(id);
	}

	@RequestMapping(value = "vehicleNum/{vehicleNumber}")
	public DriverModel getDriverDataByVehicleNumber(@PathVariable String vehicleNumber) {

		return driverService.getDriverDataByVehicleNumber(vehicleNumber);

	}

}

package com.touk.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touk.parking.model.CostModel;
import com.touk.parking.model.DriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
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

	@RequestMapping(value = "getCost/{pesel}")
	public CostModel getCost(@PathVariable int pesel) {

		return driverService.getCost(pesel);
	}

	@PutMapping(value = "updateDriverStopMeter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDriverMeterStop(@RequestBody DriverModelUpdateMeterState driverUpdate) {

		driverService.updateDriverDataStopMeter(driverUpdate);
	}

	@PutMapping(value = "updateDriverStartMeter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDriverMeterStart(@RequestBody DriverModelUpdateMeterState driverUpdate) {
		driverService.updateDriverDataStartMeter(driverUpdate);
	}

}

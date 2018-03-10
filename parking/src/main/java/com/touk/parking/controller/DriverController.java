package com.touk.parking.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.touk.parking.model.CostDriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;
import com.touk.parking.service.DriverService;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

	@Autowired
	DriverService driverService;

	@CrossOrigin
	@RequestMapping(value = "id/{id}")
	public FullDriverModel getDriverDataById(@PathVariable int id) {

		return driverService.getDriverDataById(id);
	}

	@CrossOrigin
	@RequestMapping(value = "get-cost/{pesel}")
	public CostDriverModel getCost(@PathVariable int pesel) throws ParseException {

		return driverService.createModelForDriver(pesel);
	}

	@CrossOrigin
	@PutMapping(value = "update-driver-stop", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDriverMeterStop(@RequestBody DriverModelUpdateMeterState driverUpdate) throws ParseException {

		driverService.updateDriverDataStopMeter(driverUpdate);
	}

	@CrossOrigin
	@PutMapping(value = "update-driver-start", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDriverMeterStart(@RequestBody DriverModelUpdateMeterState driverUpdate) throws ParseException {
		driverService.updateDriverDataStartMeter(driverUpdate);
	}

}

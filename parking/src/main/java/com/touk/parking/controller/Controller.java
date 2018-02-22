package com.touk.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touk.parking.model.DriverModel;
import com.touk.parking.service.DriverService;

@RestController
@RequestMapping(value = "/driver")
public class Controller {

	@Autowired
	DriverService driverService;

	@RequestMapping(value = "/test")
	public DriverModel getDriverService() {
		System.out.println("aaaaaaaaa");
	//	return driverService.getDriverData(id);
		return null;

	}

}

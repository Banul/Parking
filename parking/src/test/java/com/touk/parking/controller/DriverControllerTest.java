package com.touk.parking.controller;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.touk.parking.model.DriverModel;
import com.touk.parking.service.DriverService;
import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(DriverController.class)

public class DriverControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DriverService service;

	@Test
	public void test() throws Exception {
		DriverModel testDriver = new DriverModel(12, "Krzysztof", "Jarzyna", "2018-01-01", "2017-12-30", true, false, 0, "ZZZ");
		given(service.getDriverDataById(12)).willReturn(testDriver);

		mvc.perform(get("/driver/id/12")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo("Krzysztof")))
				.andExpect(jsonPath("$.surname", equalTo("Jarzyna")))
				.andExpect(jsonPath("$.meterLastTimeStart",equalTo("2018-01-01")))
				.andExpect(jsonPath("$.meterLastTimeStop",equalTo("2017-12-30")))
				.andExpect(jsonPath("$.vip",equalTo(true)))
				.andExpect(jsonPath("$.meterActive", equalTo(false)))
				.andExpect(jsonPath("$.currentCost",equalTo(0.0)))
				.andExpect(jsonPath("$.vehicleNumber",equalTo("ZZZ")));

	}

}
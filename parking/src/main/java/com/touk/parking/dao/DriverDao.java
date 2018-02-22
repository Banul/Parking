package com.touk.parking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.touk.parking.model.DriverModel;

@Repository
public interface DriverDao {

	public DriverModel getDriverData(int id);
}

package com.touk.parking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Table (name = "driver")
@Entity
public class DriverModel {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column (name = "first_name")
	private String name;
	
	@Column (name = "surname")
	private String surname;
	
	@Column (name = "meter_last_start_time")
	private Date meterLastTimeStart;
	
	@Column (name = "meter_last_stop_time")
	private Date meterLastTimeStop;
	
	@Column (name = "vip")
	private boolean isVip;
	
	@Column (name = "meter_active")
	private boolean isMeterActive;
	
	@Column (name = "cost")
	private double currentCost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getMeterLastTimeStart() {
		return meterLastTimeStart;
	}

	public void setMeterLastTimeStart(Date meterLastTimeStart) {
		this.meterLastTimeStart = meterLastTimeStart;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public boolean isMeterActive() {
		return isMeterActive;
	}

	public void setMeterActive(boolean isMeterActive) {
		this.isMeterActive = isMeterActive;
	}

	public Date getMeterLastTimeStop() {
		return meterLastTimeStop;
	}

	public void setMeterLastTimeStop(Date meterLastTimeStop) {
		this.meterLastTimeStop = meterLastTimeStop;
	}

	public double getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(double currentCost) {
		this.currentCost = currentCost;
	}


}

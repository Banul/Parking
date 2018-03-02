package com.touk.parking.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "driver")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class FullDriverModel {

	public FullDriverModel(int id, String fName, String sName, String meterLastStartTime, String meterLastStopTime,
			boolean vip, boolean meterActive, int pesel, String vehicleNumber) {
		this.id = id;
		this.name = fName;
		this.surname = sName;
		this.meterLastTimeStart = meterLastStartTime;
		this.meterLastTimeStop = meterLastStopTime;
		this.isVip = vip;
		this.isMeterActive = meterActive;
		this.vehicleNumber = vehicleNumber;
		this.pesel = pesel;
	}

	public FullDriverModel() {

	}

	public FullDriverModel(String timeStart, boolean isVip, boolean isMeterActive) {
		this.meterLastTimeStart = timeStart;
		this.isVip = isVip;
		this.isMeterActive = isMeterActive;
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "meter_last_start_time")
	private String meterLastTimeStart;

	@Column(name = "meter_last_stop_time")
	private String meterLastTimeStop;

	@Column(name = "vip")
	private boolean isVip;

	@Column(name = "meter_active")
	private boolean isMeterActive;

	@Column(name = "vehicle_number")
	private String vehicleNumber;

	@Column(name = "pesel")
	private int pesel;

	@OneToMany(mappedBy = "fullDriverModel")
	@JsonBackReference

	private List<TransactionModel> transactionModels;

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

	public String getMeterLastTimeStart() {
		return meterLastTimeStart;
	}

	public void setMeterLastTimeStart(String meterLastTimeStart) {
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

	public String getMeterLastTimeStop() {
		return meterLastTimeStop;
	}

	public void setMeterLastTimeStop(String meterLastTimeStop) {
		this.meterLastTimeStop = meterLastTimeStop;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

}

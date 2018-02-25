package com.touk.parking.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.touk.parking.utils.CurrentDateReturner;

public class DriverModelUpdateMeterState {

	private int pesel;
	private boolean isMeterActive;
	private Date dateToUpdate = CurrentDateReturner.returnCurrentDate();

	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public boolean isMeterActive() {
		return isMeterActive;
	}

	public void setMeterActive(boolean isMeterActive) {
		this.isMeterActive = isMeterActive;
	}

	public Date getDate() {
		return dateToUpdate;
	}

	public void setDate(Date date) {
		this.dateToUpdate = date;
	}

	
}

package com.touk.parking.model;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.touk.parking.utils.CurrentDateReturner;
import com.touk.parking.utils.DateConverter;

public class DriverModelUpdateMeterState {

	private int pesel;
	private boolean isMeterActive;
	private LocalDateTime dateToUpdate = CurrentDateReturner.returnCurrentDate();

	public int getPesel() {
		return pesel;
	}

	public boolean isMeterActive() {
		return isMeterActive;
	}

	public void setMeterActive(boolean isMeterActive) {
		this.isMeterActive = isMeterActive;
	}

	public Date getDate() throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = this.dateToUpdate.format(formatter);
        Date output = DateConverter.convertDate(formatDateTime);
        return output;
	}
	
}

package com.touk.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "parking")
public class ParkingModel {
	
	@Id 
	@Column (name = "id")
	int id;
	
	@Column (name = "car_limit")
	int carlimit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarlimit() {
		return carlimit;
	}

	public void setCarlimit(int carlimit) {
		this.carlimit = carlimit;
	}
	
	
	
	
}

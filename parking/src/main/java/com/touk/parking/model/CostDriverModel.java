package com.touk.parking.model;

public class CostDriverModel {

	public CostDriverModel(double cost, boolean isMeterActive) {
		this.cost = cost;
		this.isMeterActive = isMeterActive;
	}
	
	private double cost;
	private boolean isMeterActive;

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isMeterActive() {
		return isMeterActive;
	}

	public void setMeterActive(boolean isMeterActive) {
		this.isMeterActive = isMeterActive;
	}
	
	

}

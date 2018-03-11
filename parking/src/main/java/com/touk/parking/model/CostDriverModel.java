package com.touk.parking.model;

public class CostDriverModel {

	public CostDriverModel(MoneyModel moneyModel, boolean isMeterActive) {
		this.moneyModel = moneyModel;
		this.isMeterActive = isMeterActive;
	}

	private MoneyModel moneyModel;
	private boolean isMeterActive;

	public boolean isMeterActive() {
		return isMeterActive;
	}


}

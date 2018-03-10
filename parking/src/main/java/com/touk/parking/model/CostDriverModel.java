package com.touk.parking.model;

public class CostDriverModel {

	public CostDriverModel(MoneyModel moneyModel, boolean isMeterActive) {
		this.moneyModel = moneyModel;
		this.isMeterActive = isMeterActive;
	}

	private MoneyModel moneyModel;
	private boolean isMeterActive;

	public MoneyModel getMoneyModel() {
		return moneyModel;
	}

	public boolean isMeterActive() {
		return isMeterActive;
	}


}

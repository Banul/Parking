package com.touk.parking.model;

public class TransactionAggregateModelContainingMoneyModel {

	private String date;
	private MoneyModel moneyModel;

	public TransactionAggregateModelContainingMoneyModel(TransactionAggregateModel transactionAgg) {
		this.date = transactionAgg.getDate();
		this.moneyModel = new MoneyModel(transactionAgg.getTotalIncome(), transactionAgg.getCurrency());
	}

	public String getDate() {
		return date;
	}

	public MoneyModel getMoneyModel() {
		return moneyModel;
	}

}

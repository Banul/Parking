package com.touk.parking.model;

public class TransactionAggregateModelContainingMoneyModel {

	public TransactionAggregateModelContainingMoneyModel(TransactionAggregateModel transactionAgg) {
		this.date = transactionAgg.getDate();
		this.moneyModel = MoneyModel.pln(transactionAgg.getTotalIncome());// only one currency, so .pln method used
	}

	private String date;
	private MoneyModel moneyModel;

	public String getDate() {
		return date;
	}

}

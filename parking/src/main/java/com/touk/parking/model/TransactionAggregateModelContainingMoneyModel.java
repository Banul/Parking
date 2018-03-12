package com.touk.parking.model;


//MoneyModel, transactionAggModel, ten 3 model najdłuższy
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

	public MoneyModel getMoneyModel() {
		return moneyModel;
	}


	
	

}

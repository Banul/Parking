package com.touk.parking.service;

import com.touk.parking.model.TransactionAggregateModelContainingMoneyModel;

public interface TransactionAggregateService {

	public TransactionAggregateModelContainingMoneyModel getEarningsByDate(String date);

}

package com.touk.parking.service;


import java.util.Optional;

import com.touk.parking.model.TransactionAggregateModelContainingMoneyModel;

public interface TransactionAggregateService {

	public TransactionAggregateModelContainingMoneyModel getEarningsByDate(String date);

}

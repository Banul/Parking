package com.touk.parking.service;

import com.touk.parking.model.TransactionAggregateModel;

public interface TransactionAggregateService {
	
	public TransactionAggregateModel getEarningsByDate(String date);

}

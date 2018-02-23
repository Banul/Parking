package com.touk.parking.dao;

import com.touk.parking.model.TransactionAggregateModel;

public interface TransactionAggregateDao {

	public TransactionAggregateModel getEarningsByDate(String date);

}

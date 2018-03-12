package com.touk.parking.dao;

import javax.persistence.NoResultException;
import com.touk.parking.model.TransactionAggregateModel;

public interface TransactionAggregateDao {

	public TransactionAggregateModel getEarningsByDate(String date)  throws NoResultException;

}

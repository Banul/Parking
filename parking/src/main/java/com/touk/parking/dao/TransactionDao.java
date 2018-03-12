package com.touk.parking.dao;

import java.util.List;

import com.touk.parking.model.TransactionModel;

public interface TransactionDao {

	public List<TransactionModel> getTransactionsByDate(String date);

}

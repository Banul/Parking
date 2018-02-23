package com.touk.parking.service;

import java.util.List;

import com.touk.parking.model.TransactionModel;

public interface TransactionService {

	public List <TransactionModel> getTransactionsByDate(String date);
	
}

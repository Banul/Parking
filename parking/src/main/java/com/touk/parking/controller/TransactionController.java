package com.touk.parking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.touk.parking.model.TransactionAggregateModel;
import com.touk.parking.model.TransactionModel;
import com.touk.parking.service.TransactionAggregateService;
import com.touk.parking.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")


public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionAggregateService transactionAggregateService;

	@RequestMapping(value = "/{date}")
	public List<TransactionModel> getTransactionByDate(@PathVariable String date) {

		return transactionService.getTransactionsByDate(date);
	}
	
	@RequestMapping(value = "/earning/{date}")
	public TransactionAggregateModel getTransactionEarningByDate(@PathVariable String date) {
		return transactionAggregateService.getEarningsByDate(date);
	}

}
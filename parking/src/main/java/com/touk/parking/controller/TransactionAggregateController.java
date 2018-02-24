package com.touk.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touk.parking.model.TransactionAggregateModel;
import com.touk.parking.service.TransactionAggregateService;

@RestController
@RequestMapping(value = "/transactionTotal")

public class TransactionAggregateController {

	@Autowired
	TransactionAggregateService transactionAggregateService;

	@RequestMapping(value = "/{date}")
	public TransactionAggregateModel getTransactionEarningByDate(@PathVariable String date) {
		return transactionAggregateService.getEarningsByDate(date);
	}

}
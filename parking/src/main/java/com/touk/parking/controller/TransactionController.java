package com.touk.parking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.touk.parking.model.TransactionModel;
import com.touk.parking.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/{date}")
	public List<TransactionModel> getTransactionByDate(@PathVariable String date) {

		return transactionService.getTransactionsByDate(date);
	}



}

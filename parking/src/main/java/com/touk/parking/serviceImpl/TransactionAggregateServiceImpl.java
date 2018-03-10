package com.touk.parking.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.touk.parking.dao.TransactionAggregateDao;
import com.touk.parking.model.TransactionAggregateModel;
import com.touk.parking.model.TransactionAggregateModelContainingMoneyModel;
import com.touk.parking.service.TransactionAggregateService;

@Service
public class TransactionAggregateServiceImpl implements TransactionAggregateService {

	@Autowired
	TransactionAggregateDao transactionAggregateDao;

	public TransactionAggregateModelContainingMoneyModel getEarningsByDate(String date) {

		TransactionAggregateModel agg = transactionAggregateDao.getEarningsByDate(date);
		return new TransactionAggregateModelContainingMoneyModel(agg);
	}

}

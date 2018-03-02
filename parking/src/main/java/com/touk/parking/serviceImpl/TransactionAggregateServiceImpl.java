package com.touk.parking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.touk.parking.dao.TransactionAggregateDao;
import com.touk.parking.model.TransactionAggregateModel;
import com.touk.parking.service.TransactionAggregateService;

@Service
public class TransactionAggregateServiceImpl implements TransactionAggregateService {

	@Autowired
	TransactionAggregateDao transactionAggregateDao;

	public TransactionAggregateModel getEarningsByDate(String date) {

		return transactionAggregateDao.getEarningsByDate(date);
	}

}

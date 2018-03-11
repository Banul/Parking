package com.touk.parking.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.touk.parking.dao.TransactionDao;
import com.touk.parking.model.TransactionModel;
import com.touk.parking.service.TransactionService;

@Service
@Primary
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;

	public List<TransactionModel> getTransactionsByDate(String date) {
		return transactionDao.getTransactionsByDate(date);
	}

}

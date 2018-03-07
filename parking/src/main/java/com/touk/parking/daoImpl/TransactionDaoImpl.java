package com.touk.parking.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.touk.parking.dao.TransactionDao;
import com.touk.parking.model.TransactionModel;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	EntityManager em;

	public List<TransactionModel> getTransactionsByDate(String date) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TransactionModel> cq = cb.createQuery(TransactionModel.class);
		Root<TransactionModel> transaction = cq.from(TransactionModel.class);

		cq.select(transaction).where(cb.equal(transaction.get("date"), date));
		TypedQuery<TransactionModel> q = em.createQuery(cq);
		List<TransactionModel> transactionData;

		try {
			transactionData = q.getResultList();
		} catch (NoResultException e) {
			transactionData = null;
		}

		return transactionData;
	}

}

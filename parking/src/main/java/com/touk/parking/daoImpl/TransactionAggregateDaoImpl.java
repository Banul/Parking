package com.touk.parking.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.touk.parking.dao.TransactionAggregateDao;
import com.touk.parking.model.TransactionAggregateModel;

@Repository
public class TransactionAggregateDaoImpl implements TransactionAggregateDao {

	@PersistenceContext
	EntityManager em;

	public TransactionAggregateModel getEarningsByDate(String date) {
		
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<TransactionAggregateModel> cq = cb.createQuery(TransactionAggregateModel.class);
		 Root<TransactionAggregateModel> transactionAgg = cq.from(TransactionAggregateModel.class);
		
		 cq.select(transactionAgg).where(cb.equal(transactionAgg.get("date"), date));
		 TypedQuery<TransactionAggregateModel> q = em.createQuery(cq);
		 TransactionAggregateModel transactionData;
		 try {
		  transactionData= q.getSingleResult();
		 }
		 catch (Exception e) {
			 transactionData = null;
		 }
		
		 return transactionData;
		
	}

}

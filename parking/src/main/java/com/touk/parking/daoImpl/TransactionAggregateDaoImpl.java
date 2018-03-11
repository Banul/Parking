package com.touk.parking.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.touk.parking.dao.TransactionAggregateDao;
import com.touk.parking.model.TransactionAggregateModel;

@Repository
@Primary
public class TransactionAggregateDaoImpl implements TransactionAggregateDao {

	@PersistenceContext
	EntityManager em;

	public TransactionAggregateModel getEarningsByDate(String date) throws NoResultException{
		
		TypedQuery<TransactionAggregateModel> query = em.createQuery("select t from TransactionAggregateModel t where t.date=:date", TransactionAggregateModel.class);
		query.setParameter("date", date);
        query.setMaxResults(1);     
        TransactionAggregateModel trans = query.getResultList().stream().findFirst().orElse(null); 
        if (trans != null) {
        	return trans;
        }
        
        else {
        	throw new NoResultException("No results for inserted date!");
        }
		
	}

}

package com.touk.parking.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.touk.parking.dao.TransactionDao;
import com.touk.parking.model.TransactionModel;

@Repository
@Primary
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	EntityManager em;

	public List<TransactionModel> getTransactionsByDate(String date){

		TypedQuery<TransactionModel> query = em.createQuery("select t from TransactionModel t where t.date=:date", TransactionModel.class);
		query.setParameter("date", date);
        query.setMaxResults(1);     
        List<TransactionModel> trans = query.getResultList();
        if (trans.size() != 0) {
        	return trans;
        }
        
        else {
        	throw new NoResultException("No results for inserted date" + date);
        }
		
	}

}

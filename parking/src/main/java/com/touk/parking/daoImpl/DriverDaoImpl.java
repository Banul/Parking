package com.touk.parking.daoImpl;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

@Repository
@Primary
public class DriverDaoImpl implements DriverDao {

	@PersistenceContext
	EntityManager em;

	public FullDriverModel getDriverDataById(int id) throws NoResultException {

		TypedQuery<FullDriverModel> query = em.createQuery("select d from FullDriverModel d where d.id=:id", FullDriverModel.class);
		query.setParameter("id", id);
        query.setMaxResults(1);     
        FullDriverModel driver = query.getResultList().stream().findFirst().orElse(null); 
        if (driver != null) {
        	return driver;
        }
        
        else {
        	throw new NoResultException("No results for inserted id!");
        }
		
	}

	public FullDriverModel getMeterTime(int pesel) throws NoResultException{

		TypedQuery<FullDriverModel> query = em.createQuery("select d from FullDriverModel d where d.pesel=:pesel", FullDriverModel.class);
		query.setParameter("pesel", pesel);
        FullDriverModel driver = query.getResultList().stream().findFirst().orElse(null); 
        if (driver != null) {
        	return driver;
        }
        else {
        	throw new NoResultException("No results for inserted id!");
        }

	}
	
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate) throws ParseException {
		boolean meterNewStatus = driverUpdate.isMeterActive();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<FullDriverModel> update = cb.createCriteriaUpdate(FullDriverModel.class);
		Root<FullDriverModel> root = update.from(FullDriverModel.class);

			update.set("isMeterActive", meterNewStatus).set(timeColumnToUpdate, driverUpdate.getDate())
					.where(cb.equal(root.get("pesel"), driverUpdate.getPesel()));
			em.createQuery(update).executeUpdate();
			
	}

}

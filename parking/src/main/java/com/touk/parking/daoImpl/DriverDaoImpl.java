package com.touk.parking.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.DriverModel;
import com.touk.parking.model.DriverModelUpdateMeterState;

@Repository
public class DriverDaoImpl implements DriverDao {

	@PersistenceContext
	EntityManager em;

	public DriverModel getDriverDataById(int id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DriverModel> cq = cb.createQuery(DriverModel.class);
		Root<DriverModel> driver = cq.from(DriverModel.class);
		cq.select(driver).where(cb.equal(driver.get("id"), id));
		DriverModel driverData;

		TypedQuery<DriverModel> q = em.createQuery(cq);
		try {
			 driverData = q.getSingleResult();
		}
		catch(Exception e) {
			driverData = null;
		}
		
		System.out.print(driverData);

		return driverData;
	}

	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DriverModel> cq = cb.createQuery(DriverModel.class);
		Root<DriverModel> driver = cq.from(DriverModel.class);
		cq.select(driver).where(cb.equal(driver.get("vehicleNumber"), vehicleNumber));
		TypedQuery<DriverModel> q = em.createQuery(cq);
		DriverModel driverData = q.getSingleResult();

		return driverData;
	}

	public DriverModel getMeterLastStartAndStopTime(int pesel) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DriverModel> cq = cb.createQuery(DriverModel.class);
		Root<DriverModel> driver = cq.from(DriverModel.class);
		cq.multiselect(driver.get("meterLastTimeStart"), driver.get("meterLastTimeStop"), driver.get("isVip"))
				.where(cb.equal(driver.get("pesel"), pesel));
		TypedQuery<DriverModel> q = em.createQuery(cq);
		DriverModel results;
		try {
			results = q.getSingleResult();
		}
		catch(Exception e) {
			results = null;
		}
	
		return results;
		

	}

	@Transactional
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate) {
		boolean meterNewStatus = driverUpdate.isMeterActive();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<DriverModel> update = cb.createCriteriaUpdate(DriverModel.class);
		Root<DriverModel> root = update.from(DriverModel.class);
		try {
		update.set("isMeterActive", meterNewStatus)
				.set(timeColumnToUpdate, driverUpdate.getDate())
				.where(cb.equal(root.get("pesel"), driverUpdate.getPesel()));
		em.createQuery(update).executeUpdate();
		}
		catch(Exception e) {
			
		}
	}

}

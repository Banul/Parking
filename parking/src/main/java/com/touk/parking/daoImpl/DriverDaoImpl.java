package com.touk.parking.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.touk.parking.dao.DriverDao;
import com.touk.parking.model.DriverModel;

@Repository
public class DriverDaoImpl implements DriverDao {

	@PersistenceContext
	EntityManager em;

	public DriverModel getDriverDataById(int id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DriverModel> cq = cb.createQuery(DriverModel.class);
		Root<DriverModel> driver = cq.from(DriverModel.class);
		cq.select(driver).where(cb.equal(driver.get("id"), id));

		TypedQuery<DriverModel> q = em.createQuery(cq);
		DriverModel driverData = q.getSingleResult();

		return driverData;
	}

	public DriverModel getDriverDataByVehicleNumber(String vehicleNumber) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DriverModel> cq = cb.createQuery(DriverModel.class);
		Root<DriverModel> driver = cq.from(DriverModel.class);
		System.out.println(vehicleNumber);
		cq.select(driver).where(cb.equal(driver.get("vehicleNumber"), vehicleNumber));

		TypedQuery<DriverModel> q = em.createQuery(cq);
		DriverModel driverData = q.getSingleResult();

		return driverData;
	}

}

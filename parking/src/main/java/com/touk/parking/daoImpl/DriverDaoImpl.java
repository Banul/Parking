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
import com.touk.parking.model.DriverModelUpdateMeterState;
import com.touk.parking.model.FullDriverModel;

@Repository
public class DriverDaoImpl implements DriverDao {

	@PersistenceContext
	EntityManager em;

	public FullDriverModel getDriverDataById(int id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FullDriverModel> cq = cb.createQuery(FullDriverModel.class);
		Root<FullDriverModel> driver = cq.from(FullDriverModel.class);
		cq.select(driver).where(cb.equal(driver.get("id"), id));
		FullDriverModel driverData;

		TypedQuery<FullDriverModel> q = em.createQuery(cq);
		try {
			driverData = q.getSingleResult();
		} catch (Exception e) {
			driverData = null;
		}

		System.out.print(driverData);

		return driverData;
	}

	public FullDriverModel getMeterTime(int pesel) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FullDriverModel> cq = cb.createQuery(FullDriverModel.class);
		Root<FullDriverModel> driver = cq.from(FullDriverModel.class);
		cq.multiselect(driver.get("meterLastTimeStart"), driver.get("isVip"),
				driver.get("isMeterActive")).where(cb.equal(driver.get("pesel"), pesel));
		TypedQuery<FullDriverModel> q = em.createQuery(cq);
		FullDriverModel results;
		try {
			results = q.getSingleResult();
		} catch (Exception e) {
			results = null;
		}

		return results;

	}

	@Transactional
	public void updateDriverData(DriverModelUpdateMeterState driverUpdate, String timeColumnToUpdate) {
		boolean meterNewStatus = driverUpdate.isMeterActive();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<FullDriverModel> update = cb.createCriteriaUpdate(FullDriverModel.class);
		Root<FullDriverModel> root = update.from(FullDriverModel.class);
		try {
			update.set("isMeterActive", meterNewStatus).set(timeColumnToUpdate, driverUpdate.getDate())
					.where(cb.equal(root.get("pesel"), driverUpdate.getPesel()));
			em.createQuery(update).executeUpdate();
		} catch (Exception e) {

		}
	}

}

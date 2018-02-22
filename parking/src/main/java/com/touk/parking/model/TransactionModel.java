package com.touk.parking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class TransactionModel {
	
	@Id
	@Column (name = "id")
	int id;
	
	@Column (name = "date")
	String date;
	
	@Column (name = "price")
	double price;
	
	@Column (name = "transaction_finished")
	boolean isTransactionFinished;
	
	@ManyToOne (targetEntity=DriverModel.class, fetch=FetchType.LAZY)
	@JoinColumn(name="driver_id")
    @JsonManagedReference

	private DriverModel driverModel;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isTransactionFinished() {
		return isTransactionFinished;
	}

	public void setTransactionFinished(boolean isTransactionFinished) {
		this.isTransactionFinished = isTransactionFinished;
	}
	
	
}

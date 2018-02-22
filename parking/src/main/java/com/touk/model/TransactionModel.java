package com.touk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "transaction")
public class TransactionModel {
	
	@Id
	@Column (name = "id")
	int id;
	
	@Column (name = "date")
	Date date;
	
	@Column (name = "price")
	double price;
	
	@Column (name = "transaction_finished")
	boolean isTransactionFinished;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

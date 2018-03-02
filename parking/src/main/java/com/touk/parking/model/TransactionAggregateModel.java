package com.touk.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_aggregate")
public class TransactionAggregateModel {

	public TransactionAggregateModel() {

	}

	public TransactionAggregateModel(String date, double totalIncome) {
		this.date = date;
		this.totalIncome = totalIncome;
	}

	@Id
	@Column(name = "date")
	String date;

	@Column(name = "total")
	double totalIncome;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

}

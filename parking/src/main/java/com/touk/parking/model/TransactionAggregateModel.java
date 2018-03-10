package com.touk.parking.model;

import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "transaction_aggregate")
public class TransactionAggregateModel {

	public TransactionAggregateModel() {

	}

	public TransactionAggregateModel(String date, BigDecimal totalIncome, Currency currency) {
		this.date = date;
		this.totalIncome = totalIncome;
		this.currency = currency;
	}

	@Id
	@Column(name = "date")
	private String date;

	@Column(name = "total")
	private BigDecimal totalIncome;

	@Column(name = "currency")
	private Currency currency;
	
	public String getDate() {
		return date;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	

}

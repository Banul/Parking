package com.touk.parking.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

// source: https://stackoverflow.com/questions/1359817/using-bigdecimal-to-work-with-currencies
public class MoneyModel {
	private static final Currency PLN = Currency.getInstance("PLN");
	private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

	private BigDecimal amount;
	private Currency currency;

	public static MoneyModel pln (BigDecimal amount) {
		return new MoneyModel(amount, PLN);
	}

	MoneyModel (BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }

    MoneyModel (BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.amount = amount;
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), rounding);
    }

    
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}

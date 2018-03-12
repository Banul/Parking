package com.touk.parking.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import com.touk.parking.constans.ConstansHolder;

public class MoneyModel {
	private static final Currency PLN = ConstansHolder.PLN;
	private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

	private BigDecimal amount;
	private Currency currency;

	// only for testing purpose
	public static MoneyModel pln (BigDecimal amount) {
		return new MoneyModel(amount, PLN);
	}
	
	public MoneyModel (BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }

    MoneyModel (BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.amount = amount;
        this.currency = currency;
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), rounding);
    }


	public MoneyModel() {}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

}

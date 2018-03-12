package com.touk.parking.constans;

import java.util.Currency;

public class ConstansHolder {
	
    private ConstansHolder() { }  // Prevents instantiation

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final Currency PLN = Currency.getInstance("PLN");
}


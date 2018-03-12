package com.touk.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import com.touk.parking.constans.ConstansHolder;


public class DateConverter {

	@Bean
	public DateConverter dateConverter() {
		return new DateConverter();
	}
	
	public Date convertDate(String dateString) throws ParseException  {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstansHolder.DATE_FORMAT);
		Date parsedDate = sdf.parse(dateString);
		return parsedDate;
	}

}

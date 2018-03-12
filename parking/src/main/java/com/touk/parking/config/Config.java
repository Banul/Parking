package com.touk.parking.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.touk.parking.utils.DateConverter;

@Configuration
public class Config {

	@Bean
	@Qualifier("dateConverter")
	DateConverter first() {
		return new DateConverter();
	}

}

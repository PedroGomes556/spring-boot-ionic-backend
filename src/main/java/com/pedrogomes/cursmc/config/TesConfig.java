package com.pedrogomes.cursmc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrogomes.cursmc.services.DBService;
import com.pedrogomes.cursmc.services.EmailService;
import com.pedrogomes.cursmc.services.MockEmailService;

@Configuration
@Profile("test")
public class TesConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean 
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
}

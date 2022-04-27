package com.phc.cryptocentral;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptocentralApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptocentralApplication.class, args);
	}
	
	@PostConstruct
    public void init(){
      // Setting Spring Boot SetTimeZone
      TimeZone.setDefault(TimeZone.getTimeZone("Europe/Bucharest"));
    }

}

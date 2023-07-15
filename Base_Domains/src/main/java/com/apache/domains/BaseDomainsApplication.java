package com.apache.domains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseDomainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseDomainsApplication.class, args);
	}

}

// Base_Domain is stand alone project, so we don't have to run it on Tomcat. we will be creating domain entities in base domain 
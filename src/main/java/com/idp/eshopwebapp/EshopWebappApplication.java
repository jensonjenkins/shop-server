package com.idp.eshopwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@SpringBootApplication
public class EshopWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopWebappApplication.class, args);

	}

}

package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//runs under http://localhost:8080/login/
@SpringBootApplication
@ComponentScan({"com.gcu"})
public class Topic43Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic43Application.class, args);
	}

}

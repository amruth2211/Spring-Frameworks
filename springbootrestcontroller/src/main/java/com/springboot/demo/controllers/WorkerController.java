package com.springboot.demo.controllers;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.models.Bank;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@GetMapping("/showWorker")
	public Bank showWorker() {
		return new Bank(101, "Amruth", "Chowdary", "10000", new Date(System.currentTimeMillis()), "IT",
				"chowdary@gmail.com");
	}

	@GetMapping("/all/showWorkers")
	public List<Bank> showWorkers() {
		return Arrays.asList(
				new Bank(101, "Amruth", "Chowdary", "10000", new Date(System.currentTimeMillis()), "IT",
						"chowdary@gmail.com"),
				new Bank(102, "Aasrith", "chowdary", "10000", new Date(System.currentTimeMillis()), "CS",
						"aasrith@gmail.com"),
				new Bank(103, "Jeevan", "chowdary", "10000", new Date(System.currentTimeMillis()), "Accounting",
						"jeevan@gmail.com"));
	}

}



//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-jdbc</artifactId>
//</dependency>
//<dependency>
//<groupId>mysql</groupId>
//<artifactId>mysql-connector-java</artifactId>
//</dependency>
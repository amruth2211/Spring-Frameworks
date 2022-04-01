package com.springboot.demo.controllers;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.models.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return new Worker(101, "Amruth", "Chowdary", "10000", new Date(System.currentTimeMillis()), "IT",
				"chowdary@gmail.com");
	}

	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return Arrays.asList(
				new Worker(101, "Amruth", "Chowdary", "10000", new Date(System.currentTimeMillis()), "IT",
						"chowdary@gmail.com"),
				new Worker(102, "Aasrith", "chowdary", "10000", new Date(System.currentTimeMillis()), "CS",
						"aasrith@gmail.com"),
				new Worker(103, "Jeevan", "chowdary", "10000", new Date(System.currentTimeMillis()), "Accounting",
						"jeevan@gmail.com"));
	}

}


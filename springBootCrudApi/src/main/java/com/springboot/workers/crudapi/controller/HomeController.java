package com.springboot.workers.crudapi.controller;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	//
	@GetMapping("/")
	public String home() {
		return "Hello visitor!\nVisiting time: " + new Timestamp(System.currentTimeMillis());
	}
}
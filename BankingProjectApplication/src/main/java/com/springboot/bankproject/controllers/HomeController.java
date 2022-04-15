package com.springboot.bankproject.controllers;
//import com.springboot.bankproject.model.Bank;
import com.springboot.bankproject.services.BankService;

//import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired
	BankService bankService;
	
	@GetMapping("/")
	public List<String> index() {
		return bankService.getBankNames();
	}

}

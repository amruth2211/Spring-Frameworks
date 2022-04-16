package com.springboot.bankproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankproject.model.Customer;
import com.springboot.bankproject.services.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/viewProfile/{customerId}")
	public Customer viewProfile(@PathVariable Integer customerId)
	{	
			return customerService.viewProfile(customerId);	
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Integer create(@RequestBody Customer customer)
	{
			return customerService.create(customer);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public Integer delete(@PathVariable Integer customerId)
	{
			return customerService.delete(customerId);
	}
}

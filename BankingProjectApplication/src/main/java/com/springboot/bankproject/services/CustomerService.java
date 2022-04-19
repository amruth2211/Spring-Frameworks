package com.springboot.bankproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Customer;
import com.springboot.bankproject.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer viewProfile(Integer customerId)
	{
		try {
			return customerRepo.viewProfile(customerId);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}


	
	public Integer create(Customer customer)
    {
		try {
			return customerRepo.create(customer);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	public Integer delete(Integer customerId)
	{
		try {
			return customerRepo.delete(customerId);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

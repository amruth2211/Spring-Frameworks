package com.springboot.bankproject.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.repository.BankRepository;


@Service
public class BankService {

	@Autowired
	BankRepository bankRepo;
	
	public List<String> getBankNames() {
		try{
			return bankRepo.getBankNames();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}

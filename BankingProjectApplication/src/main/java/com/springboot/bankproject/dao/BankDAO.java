package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.Bank;


public interface BankDAO {
	
//	 	public int create(Bank bank)
//	            throws SQLException;
//
//	    public boolean delete(int bankCode)
//	            throws SQLException;
//
//	    public Bank update(int bankCode)
//	            throws SQLException;
//
//	    public Bank viewDetails()
//	            throws SQLException;
	    
	    public List<String> getBankNames()
	    		throws SQLException;
	
}

package com.springboot.bankproject.dao;

import java.sql.SQLException;

import com.springboot.bankproject.model.BankAccount;

public interface BankAccountDAO {
	
	public int create(BankAccount bankAccount)
            throws SQLException;

    public int update(Integer accountNo,Integer branchCode)
            throws SQLException;

	public BankAccount viewDetails(Integer accountNo)
            throws SQLException;
	
	public int delete(Integer customerId)
            throws SQLException;
}

package com.springboot.workers.springjdbcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.springjdbcexample.model.Bank;


public interface WorkerDAO {

	public void add(Bank worker) throws SQLException;

	public void delete(int workerId) throws SQLException;

	public Bank getWorker(int workerId) throws SQLException;

	public List<Bank> getWorkers() throws SQLException;

	public void update(Bank emp) throws SQLException;
}
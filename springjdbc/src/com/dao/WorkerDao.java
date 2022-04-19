package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.models.Bank;

public interface WorkerDao {

	public void setDataSource(DataSource dataSource);

	public void add(Bank worker);

	public void delete(int workerId);

	public Bank getWorker(int workerId);

	public List<Bank> getWorkers();

	public void update(Bank emp);
}
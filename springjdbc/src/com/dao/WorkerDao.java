package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.models.Worker;

public interface WorkerDao {

	public void setDataSource(DataSource dataSource);

	public void add(Worker worker);

	public void delete(int workerId);

	public Worker getWorker(int workerId);

	public List<Worker> getWorkers();

	public void update(Worker emp);
}
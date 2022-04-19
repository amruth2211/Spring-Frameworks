package com.springboot.workers.springjdbcexample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Bank;

@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(Bank worker) {
		String format = """
				INSERT INTO Bank VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		jdbcTemplate.update(format, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
				worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

		System.out.println("new Record created");
	}

	@Override
	public void delete(int workerId) {
		String format = """
				DELETE FROM Bank where worker_id = ?
				""";
		jdbcTemplate.update(format, workerId);
		System.out.println("Record deleted");
	}

	@SuppressWarnings("deprecation")
	@Override
	public Bank getWorker(int workerId) {
		String format = """
				SELECT * FROM Bank
				    WHERE Worker_id = ?
				""";
		return jdbcTemplate.queryForObject(format, new Object[] { workerId }, new WorkerMapper());
	}

	@Override
	public List<Bank> getWorkers() {
		String format = """
				SELECT * FROM Bank
				""";
		List<Bank> list = jdbcTemplate.query(format, new WorkerMapper());
		return list;
	}

	@Override
	public void update(Bank emp) {
		String format = """
				UPDATE Bank
				    SET
				        worker_id = ?,
				        first_name = ?,
				        last_name = ?,
				        salary = ?,
				        joining_date = ?,
				        department = ?,
				        email = ?
				    WHERE worker_id = ?
				""";
		jdbcTemplate.update(format, emp.getWorkerId(), emp.getFirstName(), emp.getLastName(), emp.getSalary(),
				emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());
		System.out.println("Record Updated");
	}
}
package com.springboot.workers.springjdbcexample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;

@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(Worker worker) {
		String format = """
				INSERT INTO Worker VALUES (?, ?, ?, ?, ?, ?, ?)
				""";
		jdbcTemplate.update(format, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
				worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

		System.out.println("new Record created");
	}

	@Override
	public void delete(int workerId) {
		String format = """
				DELETE FROM Worker where worker_id = ?
				""";
		jdbcTemplate.update(format, workerId);
		System.out.println("Record deleted");
	}

	@SuppressWarnings("deprecation")
	@Override
	public Worker getWorker(int workerId) {
		String format = """
				SELECT * FROM Worker
				    WHERE Worker_id = ?
				""";
		return jdbcTemplate.queryForObject(format, new Object[] { workerId }, new WorkerMapper());
	}

	@Override
	public List<Worker> getWorkers() {
		String format = """
				SELECT * FROM Worker
				""";
		List<Worker> list = jdbcTemplate.query(format, new WorkerMapper());
		return list;
	}

	@Override
	public void update(Worker emp) {
		String format = """
				UPDATE Worker
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
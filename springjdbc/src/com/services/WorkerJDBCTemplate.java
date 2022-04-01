package com.services;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.WorkerDao;
import com.mappers.WorkerMapper;
import com.models.Worker;

public class WorkerJDBCTemplate implements WorkerDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);

	}

	@Override
	public void add(Worker worker) {
		String addQuery = "insert into worker values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(addQuery, worker.getworkerId(), worker.getfirstName(), worker.getlastName(),
				worker.getSalary(), worker.getjoiningDate(), worker.getDepartment(), worker.getEmail());
		System.out.println("Worker " + worker.getfirstName() + "'s record inserted successfully");
	}

	@Override
	public void delete(int workerId) {
		String delQuery = "delete from worker where WORKER_ID=?";
		jdbcTemplate.update(delQuery, workerId);
		System.out.println("Record #" + workerId + " deleted");
	}

	@Override
	public Worker getWorker(int workerId) {
		String getQuery = "select * from worker where WORKER_ID=?";
		Worker worker = jdbcTemplate.queryForObject(getQuery, new Object[] { workerId }, new WorkerMapper());
		return worker;
	}

	@Override
	public List<Worker> getWorkers() {
		String getQuery = "select * from worker";
		List<Worker> workers = jdbcTemplate.query(getQuery, new WorkerMapper());
		return workers;
	}

	@Override
	public void update(Worker worker) {
		String updateQuery = "update worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
		jdbcTemplate.update(updateQuery, worker.getfirstName(), worker.getlastName(), worker.getSalary(),
				worker.getjoiningDate(), worker.getDepartment(), worker.getEmail(), worker.getworkerId());
		System.out.println("Record #" + worker.getworkerId() + " updated");
	}

}
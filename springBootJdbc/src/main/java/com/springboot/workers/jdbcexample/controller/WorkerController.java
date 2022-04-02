package com.springboot.workers.jdbcexample.controller;
import com.springboot.workers.jdbcexample.model.Worker;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.repository.WorkerRepository;
import com.springboot.workers.jdbcexample.model.Worker;
@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker dispWorkerById() {
		try {
			return workerRepository.getWorker(4);
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	@GetMapping("/all/showWorkers")
	public List<Worker> dispAllWorkers(){
		try {
			return workerRepository.getWorkers();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	@GetMapping("/create")
	public String create() throws SQLException {
		workerRepository.add(new Worker(10, "Amruth", "chowdary", 30000, Date.valueOf("2022-03-21"), "Account",
                "a.seepana@my_org.in"));
		return "New Record Created Successfully";
		}
	@GetMapping("/update")
	public String update() throws SQLException {
		workerRepository.update(new Worker(10, "Aasrith", "chowdary", 30000, Date.valueOf("2022-03-21"), "Account",
                "mfs.akash@gmail.com"));
		return "Record Updated Successfully";
	}
	@GetMapping("/delete")
	public String delete() throws SQLException {
		workerRepository.delete(10);
		return "Record Deleted Successfully";
	}
}
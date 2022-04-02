package com.springboot.workers.springjdbcexample.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
//	@Autowired
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return this.workerRepository.getWorker(1);

	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() {
		return this.workerRepository.getWorkers();

	}

	@GetMapping("/create")
	public String createWorker() {
		this.workerRepository.add(new Worker(9, "Amruth", "Chowdary", 154245, new java.sql.Date(new Date().getTime()),
				"IT", "abc@gmail.com"));
		return "New Worker Created";
	}

	@GetMapping("/update")
	public String updateWorker() {
		this.workerRepository.update(new Worker(9, "Amruth", "Chowdary", 154245,
				new java.sql.Date(new Date().getTime()), "IT", "mfs.akash@gmail.com"));
		return "Worker Updated";
	}

	@GetMapping("/delete")
	public String deleteWorker() {
		this.workerRepository.delete(9);
		return "Record deleted";
	}
}
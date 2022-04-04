package com.springboot.workers.crudapi.controller;

//import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.services.WorkerService;
import com.springboot.workers.crudapi.model.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	WorkerService workerService;
	
	@GetMapping("/worker/{id}")
	public Worker showWorker(@PathVariable int id) {
		return workerService.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showWorkers() {
		return workerService.getWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody Worker worker) {
		return workerService.createWorker(worker);	
	}
	
	@PatchMapping("/update/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String> requestBody) {
		return workerService.updateWorker(id,requestBody.get("email"));
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return workerService.deleteWorkerById(id);
	}
	
}
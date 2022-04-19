package com.springboot.workers.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.workers.crudapi.model.Bank;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	WorkerRepository workerRepo;
	
	public Bank getWorker(Integer id) {
		try {
			return workerRepo.getWorker(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Bank> getWorkers() {
		try{
			return workerRepo.getWorkers();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String createWorker(Bank worker) {
		try{
			workerRepo.add(worker);
			return worker.getFirstName()+" Added Successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while adding new record";
		}		
	}
	

	public boolean updateWorker(Integer id, String email) {
		try {
			workerRepo.updateWorkerEmail(id,email);
			return true;
		} catch(SQLException e) {
			e.printStackTrace();	
			return false;
		}
	}

	public boolean deleteWorkerById(Integer id) {
		try {
			workerRepo.delete(id);
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
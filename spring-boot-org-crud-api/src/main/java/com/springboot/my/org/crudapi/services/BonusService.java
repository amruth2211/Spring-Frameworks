package com.springboot.my.org.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	
	@Autowired
	BonusRepository bonusRepo;
	
	public List<Bonus> getWorkerWithBonus(Integer id) {
		try {
			return bonusRepo.getWorkerWithBonus(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Bonus> getBonusByDept(String dept) {
		try{
			return bonusRepo.getWorkerBonusByDept(dept);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String createBonus(Integer id,Bonus bonus) {
		try{
			bonusRepo.createBonus(id,bonus);
			return bonus.getBonusAmount()+" Added Successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while adding new record";
		}		
	}
	


	public boolean deleteBonus(Integer id) {
		try {
			return bonusRepo.deleteBonus(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
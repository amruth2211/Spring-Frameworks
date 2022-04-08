package com.springboot.my.org.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.repository.BonusRepository;
import com.springboot.my.org.crudapi.repository.TitleRepository;

@Service
public class TitleService {
	
	@Autowired
	TitleRepository titleRepo;
	
	public List<Title> getWorkerWithBonus(Integer id) {
		try {
			return bonusRepo.getWorkerWithBonus(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Title> getBonusByDept(String dept) {
		try{
			return bonusRepo.getWorkerBonusByDept(dept);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String createTitle(Integer id,Title bonus) {
		try{
			titleRepo.createTitle(id,bonus);
			return bonus.getBonusAmount()+" Added Successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while adding new record";
		}		
	}
	


	public boolean deleteTitle(Integer id) {
		try {
			return titleRepo.deleteTitle(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
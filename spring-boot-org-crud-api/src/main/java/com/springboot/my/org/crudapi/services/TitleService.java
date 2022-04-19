package com.springboot.my.org.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.repository.TitleRepository;

@Service
public class TitleService {
	
	@Autowired
	TitleRepository titleRepo;
	
	public List<Title> getWorkerTitle(int id)  {
		try {
			return titleRepo.getWorkerTitle(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Title>  getAllWorkerTitleInDept(String dept) {
		try{
			return titleRepo. getAllWorkerTitleInDept(dept);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	   public boolean createTitle(int id, String title) {
	    	try {
	    		return titleRepo.createTitle(id, title);
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
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
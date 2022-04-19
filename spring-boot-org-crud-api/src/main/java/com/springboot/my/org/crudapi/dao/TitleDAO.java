package com.springboot.my.org.crudapi.dao;


import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.models.Title;

public interface TitleDAO {
	
	public List<Title> getWorkerTitle(int id) throws SQLException;
	
	public List<Title> getAllWorkerTitleInDept(String dept) throws SQLException;
	
	public boolean createTitle(int id, String title) throws SQLException;

	public boolean deleteTitle(int id) throws SQLException;
}
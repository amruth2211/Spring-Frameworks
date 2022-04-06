package com.springboot.my.org.crudapi.dao;


import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.models.Title;

public interface TitleDAO {
	
	public List<Title> getWorkerWithTitle(int id) throws SQLException;
	
	public List<Title> getAllWorkersWithTitleInDept(String dept) throws SQLException;
	
	public int createTitle(int id, String title) throws SQLException;

	public int deleteTitleLatest(int id) throws SQLException;
}
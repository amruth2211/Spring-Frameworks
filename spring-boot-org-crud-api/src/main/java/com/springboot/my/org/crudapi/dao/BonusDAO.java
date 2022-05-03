package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.models.Bonus;

public interface BonusDAO {
	//
	public List<Bonus> getWorkerWithBonus(int id) throws SQLException;

	public List<Bonus> getWorkerBonusByDept(String department) throws SQLException;

	public int createBonus(int id, Bonus bonus) throws SQLException;

	public boolean deleteBonus(int id) throws SQLException;

}
package com.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.models.Bank;

public class WorkerMapper implements RowMapper<Bank> {
	@Override
	public Bank mapRow(ResultSet result, int rowNum) throws SQLException {
		Bank worker = new Bank(result.getInt(1));
		worker.setfirstName(result.getString(2));
		worker.setlastName(result.getString(3));
		worker.setSalary(result.getString(4));
		worker.setjoiningDate(result.getDate(5));
		worker.setDepartment(result.getString(6));
		worker.setEmail(result.getString(7));
		return worker;

	}

}
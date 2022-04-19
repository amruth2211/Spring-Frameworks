package com.springboot.workers.springjdbcexample.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.springjdbcexample.model.Bank;


public class WorkerMapper implements RowMapper<Bank>{

	@Override
	public Bank mapRow(ResultSet res, int rowNum) throws SQLException {
		return new Bank(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4), res.getDate(5),
                res.getString(6), res.getString(7));
	}

}
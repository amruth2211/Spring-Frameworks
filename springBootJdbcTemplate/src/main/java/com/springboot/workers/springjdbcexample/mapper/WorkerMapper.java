package com.springboot.workers.springjdbcexample.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.springjdbcexample.model.Worker;


public class WorkerMapper implements RowMapper<Worker>{

	@Override
	public Worker mapRow(ResultSet res, int rowNum) throws SQLException {
		return new Worker(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4), res.getDate(5),
                res.getString(6), res.getString(7));
	}

}
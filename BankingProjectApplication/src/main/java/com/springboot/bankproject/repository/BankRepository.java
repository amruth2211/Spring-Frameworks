package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.BankDAO;
import com.springboot.bankproject.model.Bank;
import com.springboot.bankproject.util.DatabaseConnection;


@Repository
public class BankRepository implements BankDAO{
	 private final Connection conn; 
	    
	    public BankRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    
//	    @Override
//	    public int create(Bank bank) throws SQLException {
//	        PreparedStatement ps = conn.prepareStatement("insert into Bank values(?,?,?)");
//	        ps.setInt(1, bank.getBankCode());
//	        ps.setString(2, bank.getBankName());
////	        ps.setString(3, );
//
//	        return ps.executeUpdate();
//	    }
//	    
//	    @Override
//	    public Bank getWorker(int workerId) throws SQLException {
//	        PreparedStatement ps = conn.prepareStatement("select * from worker where worker_id=?");
//	        ps.setInt(1, workerId);
//	        ResultSet rs = ps.executeQuery();
//	        rs.next();
//	        return new Bank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6),
//	                rs.getString(7));
//	    }

	    @Override
	    public List<String> getBankNames() throws SQLException {
	        List<String> BankList = new ArrayList<>();
	        PreparedStatement ps = conn.prepareStatement("select BankName from Banks");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            BankList.add(rs.getString(1));
	        }
	        return BankList;
	    }
	    
	        
	    
}

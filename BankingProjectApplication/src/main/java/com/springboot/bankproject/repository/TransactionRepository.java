package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.TransactionDAO;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class TransactionRepository implements TransactionDAO{
	 private final Connection conn; 
	    
	    public TransactionRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    public Integer deposit(Integer accountNo,Double amount)
	            throws SQLException{
	    		
	    	  PreparedStatement ps = conn.prepareStatement(" UPDATE transactions SET amount=amount+?  where ACCNO=?");
	    	  ps.setDouble(1, amount);
		       ps.setInt(2, accountNo);
		       int rowsUpdated = ps.executeUpdate();
		       return rowsUpdated;
//		        System.out.println(rowsUpdated + " row updated");
	    }
	    public Integer withDraw(Integer accountNo,Double amount)
	            throws SQLException{
	    	
	    	  PreparedStatement ps = conn.prepareStatement(" UPDATE transactions SET amount=amount-?  where ACCNO=?");
	    	  ps.setDouble(1, amount);
		       ps.setInt(2, accountNo);
		       int rowsUpdated = ps.executeUpdate();
		       return rowsUpdated;
	    }
}

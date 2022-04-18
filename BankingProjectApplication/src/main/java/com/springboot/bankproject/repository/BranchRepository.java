package com.springboot.bankproject.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.BranchDAO;
import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.model.Branch;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class BranchRepository implements BranchDAO{
	 private final Connection conn; 

	    public BranchRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }

		@Override
		public Boolean createBranch(Branch branch) throws SQLException {
			PreparedStatement ps=conn.prepareStatement("INSERT INTO branches VALUES (?, ?, ?, ?)");

			try {
				int rowCount = ps.executeUpdate();
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		@SuppressWarnings("deprecation")
		@Override
		public Branch viewDetailsByIFSC(String ifscCode) throws SQLException {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM branches WHERE branchCode = ?");
		     ResultSet rs = ps.executeQuery();
		     rs.next();
		     return new Branch(rs.getInt(1),rs.getInt(4),rs.getString(3),AddressRepository.processAddress(rs.getString("address")));
		}


		@Override
		public List<BankAccount> showBankAccounts() throws SQLException {
		       List<BankAccount> BankList = new ArrayList<>();
		        PreparedStatement ps = conn.prepareStatement("select * from BankAccounts");
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            BankList.add(new BankAccount(rs.getInt(1),rs.getInt(4),rs.getInt(3)));
		        }
		        return BankList;
		}

		@Override
		public Boolean deleteByIFSC(String ifscCode) throws SQLException {
			PreparedStatement ps=conn.prepareStatement("DELETE FROM branches WHERE branchCode = ?");
			 ps.setString(1, ifscCode);
		        int rowDeleted = ps.executeUpdate();
		     	return rowDeleted==1;

		}


}

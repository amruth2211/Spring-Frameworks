package com.springboot.my.org.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDAO;
import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.util.DatabaseConnection;

@Repository("bonusMysqlRepository")
public class BonusRepository implements BonusDAO{
	 private final Connection conn; 
	    
	   

	    public BonusRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }

	    @Override
	    public List<Bonus> getWorkerBonusByDept(String department) throws SQLException {
	    	List<Bonus> bonusList = new ArrayList<>();
	        PreparedStatement ps = conn.prepareStatement("SELECT WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE FROM bonus INNER JOIN worker ON worker.WORKER_ID = bonus.WORKER_REF_ID WHERE worker.DEPARTMENT LIKE ? ");

	        ps.setString(1, department);
	        ResultSet rs = ps.executeQuery();
	         while(rs.next()) {
	        	 bonusList.add(new Bonus(rs.getInt(1), rs.getInt(2), rs.getDate(3)));
	         }
	         return bonusList;
	    }
		@Override
		public List<Bonus> getWorkerWithBonus(int id) throws SQLException {
			 List<Bonus> bonusList = new ArrayList<>();
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM bonus WHERE bonus.WORKER_REF_ID = ?");
	         ps.setInt(1, id);
	         ResultSet rs = ps.executeQuery();
	         while(rs.next()) {
	        	 bonusList.add(new Bonus(rs.getInt(1), rs.getInt(2), rs.getDate(3)));
	         }
	         return bonusList;
		}
		public int createBonus(int id,Bonus bonus) throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("INSERT INTO bonus(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES (?,?,?)");
	         ps.setInt(1, id);
	         ps.setInt(2, bonus.getBonusAmount());
	         ps.setDate(3, bonus.getBonusDate());
	         return ps.executeUpdate();
		}
		public boolean deleteBonus(int id) throws SQLException{
			  PreparedStatement ps = conn.prepareStatement("DELETE FROM bonus WHERE WORKER_REF_ID = ?");
		        ps.setInt(1, id);
		        int rowDeleted = ps.executeUpdate();
		     	return rowDeleted==1;
	
		}
}
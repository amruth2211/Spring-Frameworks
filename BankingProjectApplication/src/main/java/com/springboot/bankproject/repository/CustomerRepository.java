package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.model.Address;
import com.springboot.bankproject.model.Customer;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class CustomerRepository {
	    private final Connection conn; 

	    public CustomerRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
//	    public String welcome(Integer customerId)
//	            throws SQLException{
//	    	
//	    }
		
		public Customer viewProfile(Integer customerId)
	            throws SQLException{
	       
	        PreparedStatement ps = conn.prepareStatement("select name,street,city,state,country,pincode,customerId from customers INNER JOIN Address on (Address.addressId=Customers.Address) where customerid=?");
	        ps.setInt(1,customerId);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        return new Customer(rs.getString(1),new Address(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)), rs.getInt(7));
		}

//	    public int updateProfile(String name,Address address)
//	            throws SQLException{
//	    	
//	    }
//	    
//		public int editProfileForm(String name,Address address)
//	            throws SQLException{
//			
//		}
		
		public int create(Customer customer)
	            throws SQLException{
			  PreparedStatement ps = conn.prepareStatement("insert into customers values(?,?,?)");

		        ps.setString(1, customer.getName());
		        ps.setString(2, customer.getAddress());
		        ps.setInt(3, customer.getCustomerId());
		        int rowsUpdated = ps.executeUpdate();
			     return rowsUpdated;

		}
		
		public int delete(Integer customerId)
	            throws SQLException{
			  PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE customerId=?");
		        ps.setInt(1,customerId);
		        int rowsUpdated = ps.executeUpdate();
			     return rowsUpdated;
		}
}

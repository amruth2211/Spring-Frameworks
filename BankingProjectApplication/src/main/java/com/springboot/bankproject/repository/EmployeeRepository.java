package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.EmployeeDAO;

import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class EmployeeRepository implements EmployeeDAO{
	  private final Connection conn; 

	    public EmployeeRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }

	@Override
	public boolean createEmployee(Employee emp) throws SQLException {
		 PreparedStatement ps = conn.prepareStatement("INSERT INTO employees VALUES(?,?,?)");
		 ps.setInt(1, emp.getEmployeeId());
	        ps.setString(2, emp.getEmployeeName());
	        ps.setInt(3, emp.getBranchCode());
	        int rowsUpdated = ps.executeUpdate();
		     return rowsUpdated==1;

	}

	@Override
	public boolean deleteEmployee(Integer empId) throws SQLException {
		 PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE empId = ?");
		   ps.setInt(1,empId);
	        int rowsUpdated = ps.executeUpdate();
		     return rowsUpdated==1;

	}

	@Override
	public Employee getEmployeeById(Integer empId)  throws SQLException{
		 PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE empId=?");
	        ps.setInt(1,empId);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        return  new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3));

	}

	@Override
	public List<Employee> showAllEmployees() throws SQLException{
		 PreparedStatement ps = conn.prepareStatement("SELECT * FROM worker");
		  List<Employee> employeeList = new ArrayList<>();
			 ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            employeeList.add( new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3)));
		        }
		        return employeeList;
	}

	@Override
	public boolean updateEmployee(Integer empId, String name) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("UPDATE employees SET name= ? WHERE empId= ? ");
		 ps.setInt(2,empId);
		 ps.setString(1, name);
	        int rowsUpdated = ps.executeUpdate();
		     return rowsUpdated==1;
	}
}

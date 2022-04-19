package com.springboot.workers.jdbcexample.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.workers.jdbcexample.dao.WorkerDAO;
import com.springboot.workers.jdbcexample.model.Bank;
import com.springboot.workers.jdbcexample.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO {
    private final Connection conn; 
    
   

    public WorkerRepository() throws SQLException, ClassNotFoundException {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public int add(Bank worker) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into worker values(?,?,?,?,?,?,?)");
        ps.setInt(1, worker.getWorkerId());
        ps.setString(2, worker.getFirstName());
        ps.setString(3, worker.getLastName());
        ps.setInt(4, worker.getSalary());
        ps.setDate(5, worker.getJoiningDate());
        ps.setString(6, worker.getDepartment());
        ps.setString(7, worker.getEmail());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int workerId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from worker where worker_id=?");
        ps.setInt(1, workerId);
        int rowsDeleted = ps.executeUpdate();
        System.out.println("Rows deleted: " + rowsDeleted);
    }

    @Override
    public Bank getWorker(int workerId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from worker where worker_id=?");
        ps.setInt(1, workerId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Bank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6),
                rs.getString(7));
    }

    @Override
    public List<Bank> getWorkers() throws SQLException {
        List<Bank> workersList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from worker");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            workersList.add(new Bank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return workersList;
    }

    @Override
    public void update(Bank emp) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "update worker SET worker_id =?,first_name = ?,last_name =?,salary =?,joining_date = ?,department = ?,email = ? WHERE worker_id = ?");
        ps.setInt(1, emp.getWorkerId());
        ps.setString(2, emp.getFirstName());
        ps.setString(3, emp.getLastName());
        ps.setInt(4, emp.getSalary());
        ps.setDate(5, emp.getJoiningDate());
        ps.setString(6, emp.getDepartment());
        ps.setString(7, emp.getEmail());
        ps.setInt(8, emp.getWorkerId());
        int rowsUpdated = ps.executeUpdate();
        System.out.println(rowsUpdated + " row updated");
    }
}

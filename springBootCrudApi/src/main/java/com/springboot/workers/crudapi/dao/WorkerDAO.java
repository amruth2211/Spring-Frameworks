package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;
import com.springboot.workers.crudapi.model.Bank;

public interface WorkerDAO {
    public int add(Bank worker)
            throws SQLException;

    public boolean delete(int workerId)
            throws SQLException;

    public Bank getWorker(int workerId)
            throws SQLException;

    public List<Bank> getWorkers()
            throws SQLException;

    public void replace(Bank emp)
            throws SQLException;
    
    boolean updateWorkerEmail(int id,String email)
    		throws SQLException;
    
}
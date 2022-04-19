package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.models.Worker;

public interface WorkerDAO {
    public int add(Worker worker)
            throws SQLException;

    public boolean delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public void replace(Worker emp)
            throws SQLException;
    
    boolean updateWorkerEmail(int id,String email)
    		throws SQLException;
    
}
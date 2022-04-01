package com.springboot.demo.models;


import java.util.Date;
import java.util.List;
import java.util.Map;

public class Worker {
    private int workerId;
    private String firstName;
    private String lastName;
    private String salary;
    private Date joiningDate;
    private String department;
    private String email;
    public Worker() {
    	
    }
    public Worker(int workerId, String email) {
        this.workerId = workerId;
        this.email = email;
        this.joiningDate = new Date();
    }

    public Worker(int workerId, String firstName, String lastName, String salary, Date joiningDate, String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
    }
    public Worker(int workerId, String firstName, String lastName, String salary, String department,String email) {
    	this.workerId = workerId;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.salary = salary;
    	this.joiningDate = new Date();
    	this.department = department;
    	this.email = email;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FIRSTNAME is " + firstName + "\n"
                + "LAST NAME is " + lastName + "\n" + "JOINING DATE is " + joiningDate + "\n"
                + "WORKER ID is " + workerId + "\n" + "DEPARTMENT is " + department + "\n" + "EMAIL is " + email
                + "\n" + "SALARY is " + salary + "\n";
    }
}


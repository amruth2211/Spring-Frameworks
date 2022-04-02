package com.springboot.workers.springjdbcexample.model;


import java.sql.Date;

public class Worker {
    private int workerId;
    private String firstName;
    private String lastName;
    private double salary;
    private Date joiningDate;
    private String department;
    private String email;

    public Worker(int workerId, String firstName, String lastName, double salary, Date joiningDate,
            String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
    }

    public Worker(int workerId, String firstName, String lastName, int salary, String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = new Date(new java.util.Date().getTime());
        this.department = department;
        this.email = email;
    }

    public Worker(int workerId, String firstName, Date joiningDate, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.joiningDate = joiningDate;
        this.email = email;
    }

    public Worker(int workerId, String email) {
        this.workerId = workerId;
        this.email = email;
        this.joiningDate = new Date(new java.util.Date().getTime());
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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
        return "Worker [department=" + department + ", email=" + email + ", firstName=" + firstName + ", joiningDate="
                + joiningDate + ", lastName=" + lastName + ", salary=" + salary + ", workerId=" + workerId + "]";
    }

}
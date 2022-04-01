package com.springboot.workers.jdbcexample.model;

import java.sql.Date;

public class Worker implements Comparable<Worker> {
    private int workerId;
    private String firstName;
    private String lastName;
    private int salary;
    private Date joiningDate;
    private String department;
    private String email;

    public Worker(int workerId, String firstName, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.email = email;
    }

    public Worker(int workerId, String firstName, Date joiningDate, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.joiningDate = joiningDate;
        this.email = email;
    }

    public Worker(int workerId, String firstName, String lastName, int salary, String department, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    public Worker(int workerId, String firstName, String lastName, int salary, Date joiningDate, String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + workerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (workerId != other.workerId)
            return false;
        return true;
    }

    @Override
    public int compareTo(Worker o) {
        return this.workerId-o.workerId;
    }

    @Override
    public String toString() {
        return "Worker [workerId=" + workerId + ", firstName=" + firstName + ", lastName=" + lastName + ", joiningDate="
                + joiningDate + ", salary=" + salary + ", department=" + department + ", email=" + email + "]";
    }

}
package com.models;
import java.sql.Date;

public class Worker implements Comparable {
    private int workerId;
    private String firstName;
    private String lastName;
    private String salary;
    private Date joiningDate;
    private String department;
    private String email;

    public Worker(int workerId) {
        this.workerId = workerId;
    }

    public Worker(int workerId, String firstName, String lastName, String salary, Date joiningDate,
            String department, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
    }

    public int getworkerId() {
        return workerId;
    }

    public void setworkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getjoiningDate() {
        return joiningDate;
    }

    public void setjoiningDate(Date joiningDate) {
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
    public String toString() {
        return "Worker [department=" + department + ", email=" + email + ", firstName=" + firstName
                + ", joiningDate=" + joiningDate + ", lastName=" + lastName + ", salary=" + salary + ", workerId="
                + workerId + "]";
    }

    @Override
    public int compareTo(Object o) {
        Worker w=(Worker) o;
        return this.getworkerId()-w.getworkerId();
    }
}
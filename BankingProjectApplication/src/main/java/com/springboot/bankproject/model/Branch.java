package com.springboot.bankproject.model;

import java.util.List;

public class Branch implements Comparable<Branch> {
    Integer branchCode;
    Integer bankCode;
    String manager;
    Address address;
    
    List<BankAccount> bankAccounts;

    public Branch() {
    }

    public Branch(Integer branchCode, Integer bankCode, String manager, Address address) {
        this.branchCode = branchCode;
        this.bankCode = bankCode;
        this.manager = manager;
        this.address = address;
    }

    public Branch(Integer branchCode, String manager, Address address) {
        this.branchCode = branchCode;
        this.manager = manager;
        this.address = address;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getmanager() {
        return manager;
    }

    public void setmanager(String manager) {
        this.manager = manager;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
        result = prime * result + ((manager == null) ? 0 : manager.hashCode());
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
        Branch other = (Branch) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (branchCode == null) {
            if (other.branchCode != null)
                return false;
        } else if (!branchCode.equals(other.branchCode))
            return false;
        if (manager == null) {
            if (other.manager != null)
                return false;
        } else if (!manager.equals(other.manager))
            return false;
        return true;
    }

    @Override
    public int compareTo(Branch m) {
        return this.branchCode - m.branchCode;
    }

    @Override
    public String toString() {
        return "Branch [address=" + address + ", bankCode=" + bankCode + ", branchCode=" + branchCode + ", manager="
                + manager + "]";
    }

}

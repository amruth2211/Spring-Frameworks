package com.springboot.bankproject.model;

import java.util.List;

public class BankAccount {
    Integer accountNo;
    Integer customerId;
    Integer branchCode;
    List<Transaction> transactions;
    double accBalance;

    BankAccount() {
        accountNo = 0;
        accBalance = 0.0;
    }

    enum Type {
       savings,
       current;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public BankAccount(Integer accountNo, Integer customerId, Integer branchCode) {
        this.accountNo = accountNo;
        this.customerId = customerId;
        this.branchCode = branchCode;
    }

}

class SavingsAccount extends BankAccount {
    static double rateOfInterest = 10;

    public SavingsAccount(Integer accountNo, Integer customerId, Integer branchCode) {
        super(accountNo, customerId, branchCode);
    }

    public double getYearlyInterest() {
        return ((getAccBalance() * getRateOfInterest()) / 100);

    }

    private double getRateOfInterest() {
        return rateOfInterest;
    }

    public double getComputedInterest(int years) {
        double res = getYearlyInterest();
        return res * years;
    }
}

class CurrentAccount extends BankAccount {
    double avgDailyTransaction;

    CurrentAccount() {
        super();
        this.avgDailyTransaction = 0.0;
    }

    public CurrentAccount(Integer accountNo, Integer customerId, Integer branchCode, double avgDailyTransaction) {
        super(accountNo, customerId, branchCode);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public void setAvgDailyTransaction(double t) {
        avgDailyTransaction = t;
    }

    public double getAvgDailyTransaction() {
        return avgDailyTransaction;

    }

    public double getTotalTransactionAmount(int days) {
        return avgDailyTransaction * days;
    }

    public double getYearlyTransaction() {
        return getTotalTransactionAmount(365);
    }

    @Override
    public String toString() {

        return super.toString() + "\naverage daily transaction is: " + avgDailyTransaction;

    }
}

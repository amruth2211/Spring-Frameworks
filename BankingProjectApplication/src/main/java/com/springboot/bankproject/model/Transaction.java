package com.springboot.bankproject.model;

import java.sql.Date;

public class Transaction {
    Integer accountNo;
    Double amount;
    Date date;
    Integer transactionNo;

    enum TransactionType {
        credit,
        debit;
    }

    public Transaction(Integer accountNo, Double amount, Date date) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.date = date;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction [accountNo=" + accountNo + ", amount=" + amount + ", date=" + date + "]";
    }

}

package com.springboot.bankproject.model;

import java.sql.Date;

public class Transaction {
    Integer accountNo;
    Double amount;
    Date date;
    Integer transactionNo;
	private TransactionType transactionType;

    public enum TransactionType {
        credit,
        debit;
    }

    public Transaction(Integer transactionNo, Integer accountNo, Date date) {
		super();
		this.accountNo = accountNo;
		this.transactionNo=transactionNo;
		this.date = date;
	}

    public Transaction(Integer accountNo, Double amount, Date date,TransactionType transactionType) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
		this.date = date;
		this.setTransactionType(transactionType);
	}

	public Transaction(Integer accountNo, Double amount, Date date, Integer transactionNo) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
		this.date = date;
		this.transactionNo = transactionNo;
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
		return "Transaction [accountNo=" + accountNo + ", amount=" + amount + ", date=" + date + ", transactionNo="
				+ transactionNo + ", transactionType=" + transactionType + "]";
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	

}

package com;

public abstract class BankAccount {
	private int accNo;
	private String accHolder;
	protected double accbalance;

	public BankAccount(int accNo, String accHolder, double accBalance) {

		this.accNo = accNo;
		this.accHolder = accHolder;
		this.accbalance = accBalance;
	}
//
	void showBalance() {
		System.out.println("Acc Balance= " + this.accbalance);
	}

	double withdraw(double amount) {
		if (amount > this.accbalance) {
			System.out.println("insufficient balance");
		} else {
			System.out.println("withdraw completed");
			this.accbalance -= amount;
		}
		return this.accbalance;
	}

	double deposit(double amount) {
		System.out.println("Deposit completed");
		this.accbalance += amount;
		return this.accbalance;
	}
}

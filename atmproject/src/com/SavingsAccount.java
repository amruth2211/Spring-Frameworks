package com;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(int accNumber, String accHolder, double accbalance) {
		super(accNumber, accHolder, accbalance);
	}

	@Override
	protected double withdraw(double amount) {
		if (amount > 30000) {
			System.out.println("Withdraw limit exceeded. Cannot withdraw");
			return this.accbalance;
		} else {
			return super.withdraw(amount);
		}
	}

	@Override
	protected double deposit(double amount) {
		if (amount > 1000000) {
			System.out.println("Deposit limit exceeded .Cannot deposit");
			return this.accbalance;
		} else {
			return super.deposit(amount);
		}
	}

}
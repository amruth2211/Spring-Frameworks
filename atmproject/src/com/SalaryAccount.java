package com;


public class SalaryAccount extends BankAccount {

	public SalaryAccount(int accNumber, String accHolder, double accbalance) {
		super(accNumber, accHolder, accbalance);
	}

	@Override
	protected double withdraw(double amount) {
		if (amount > 100000) {
			System.out.println("Withdraw limit exceeded. Cannot withdraw");
			return this.accbalance;
		} else {
			return super.withdraw(amount);
		}
	}
	

}

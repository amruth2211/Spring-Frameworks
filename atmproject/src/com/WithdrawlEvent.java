package com;

import org.springframework.context.ApplicationEvent;
public class WithdrawlEvent extends ApplicationEvent {
String message="money has been withdrawn from your account";
double accBalance;
	public WithdrawlEvent(Object source,double accBalance) {
		super(source);
		this.accBalance=accBalance;
	}

}

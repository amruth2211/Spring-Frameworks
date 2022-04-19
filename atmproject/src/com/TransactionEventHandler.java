package com;

import org.springframework.context.ApplicationListener;

public class TransactionEventHandler implements ApplicationListener<WithdrawlEvent> {
	private void sendSMS(String message) {
		System.out.println(message);
	}

	@Override
	public void onApplicationEvent(WithdrawlEvent event) {
		sendSMS(event.toString());
	}

}

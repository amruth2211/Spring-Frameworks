package com;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
public class WithdrawlEventPublisher implements ApplicationEventPublisherAware  {
	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}
	public void publish(double accBalance) {
		WithdrawlEvent event = new WithdrawlEvent(this,accBalance);
		this.publisher.publishEvent(event);
	}
}
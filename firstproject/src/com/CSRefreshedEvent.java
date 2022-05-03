package com;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CSRefreshedEvent  implements ApplicationListener<ContextRefreshedEvent>{
//
	 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		 System.out.println("Context refreshed Received");
	}
}


package com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   	  AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

//	   	  context.start();
	   	  System.out.println();
	   	  
	      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	      System.out.println(objA.getMessage1());
	      System.out.println(objA.getMessage2());
	      
//	      System.out.println();

//	      context.stop();
	      
	      HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
	      System.out.println(objB.getMessage1());
	      System.out.println(objB.getMessage2());
	      System.out.println(objB.getMessage3());
	      
	      context.registerShutdownHook();

	}
}
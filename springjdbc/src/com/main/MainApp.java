package com.main;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpers.WorkerHelper;
import com.models.Worker;
import com.services.WorkerJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WorkerJDBCTemplate template = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
		template.delete(1);
		template.delete(10);
		List<Worker> workers=template.getWorkers();
		WorkerHelper.printWorkers(workers);
		
		System.out.println("\n\nSingle worker");
		System.out.println(template.getWorker(5));
	}

}
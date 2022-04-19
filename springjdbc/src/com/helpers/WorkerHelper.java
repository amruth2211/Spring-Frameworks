package com.helpers;

import java.util.List;

import com.models.Bank;

public class WorkerHelper {
	public static void printWorkers(List<Bank> workers) {
		for(Bank worker: workers) {
			System.out.println(worker);
		}
	}
}
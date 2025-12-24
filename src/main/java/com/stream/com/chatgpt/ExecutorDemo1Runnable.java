package com.stream.com.chatgpt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorDemo1Runnable {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		Executors.newCachedThreadPool();
		Executors.newSingleThreadExecutor();
		
		Runnable task1 = () -> {
			System.out.println("Thread1  is Executed : " + Thread.currentThread().getName());
		};
		
		Runnable task2 = () -> {
			System.out.println("Thread2 is Executed : "+Thread.currentThread().getName());
		};
		
		Runnable task3 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread3 is Executed : "+ Thread.currentThread().getName());
				
			}
		};
		
		executorService.submit(task1);
		executorService.submit(task2);
		executorService.submit(task3);
		
		executorService.shutdown();

	}

}

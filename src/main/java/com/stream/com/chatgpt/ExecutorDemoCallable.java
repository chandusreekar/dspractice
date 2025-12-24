package com.stream.com.chatgpt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemoCallable {
	public static void main(String[] args) throws Exception {
		
		ExecutorService executorService = Executors.newScheduledThreadPool(0);
		
		Callable<Integer> task1 = () -> {
			System.out.println("Thread 1" + Thread.currentThread().getName());
			return 2 + 3;
		};
		
		Callable<Integer> task2 = () -> {
			System.out.println("Thread 1" + Thread.currentThread().getName());
			return 2 + 4;
		};
		Callable<Integer> task3 = () -> {
			System.out.println("Thread 1" + Thread.currentThread().getName());
			return 2 + 8;
		};
		Future<Integer> future ;
		future = executorService.submit(task1);
		System.out.println("Rsult "+ future.get());
		future  = executorService.submit(task2);		
		System.out.println("Result "+ future.get());
		future  = executorService.submit(task3);		
		System.out.println("Result "+ future.get());
		
		executorService.shutdown();
	}

}

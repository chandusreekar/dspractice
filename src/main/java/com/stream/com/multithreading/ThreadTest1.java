package com.stream.com.multithreading;

public class ThreadTest1 {

	public static void main(String[] args) {
		Thread t1 = new Thread("Thread1");
		t1.start();
//		try {
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}

	}

}
class MyThread implements Runnable{

	 String name;
	public MyThread(String str) {
		this.name = str;
	}
	@Override
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
}
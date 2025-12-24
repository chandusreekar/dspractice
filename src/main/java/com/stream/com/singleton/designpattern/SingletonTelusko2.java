package com.stream.com.singleton.designpattern;

public class SingletonTelusko2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				TestSingleton2 t1 = TestSingleton2.getInstance();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				TestSingleton2 t2 = TestSingleton2.getInstance();
			}
		});	
		t1.start();
		t2.start();
	}
}
class TestSingleton2{
	static TestSingleton2 obj;
	private TestSingleton2() {
		System.out.println("I'm Chandra");
	}
	public static TestSingleton2 getInstance() {
		if(obj == null)
			synchronized(TestSingleton2.class) {
				if(obj == null)
				obj = new TestSingleton2();
				
			}
		return obj;
		
	}
}
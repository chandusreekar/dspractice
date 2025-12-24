package com.stream.com.singleton.designpattern;

public class SingletonInstance {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				TestSingleton a1 = TestSingleton.getInstance();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				TestSingleton a2 = TestSingleton.getInstance();
				
			}
		});
		
		t1.start();
		t2.start();

	}

}
class TestSingleton{
	private static TestSingleton obj;
	
	private TestSingleton() {
		System.out.println("I'm testing this application");
	}
	public static TestSingleton getInstance() {
		if(obj == null)
			synchronized (TestSingleton.class) {
				if(obj == null)
					obj = new TestSingleton();
			}
		
		return obj;
	}
}
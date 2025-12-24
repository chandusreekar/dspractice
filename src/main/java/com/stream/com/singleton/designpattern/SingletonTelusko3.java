package com.stream.com.singleton.designpattern;

public class SingletonTelusko3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				MyTest1 t1 = MyTest1.getInstace();
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				MyTest1 t2 = MyTest1.getInstace();
				
			}
		});
		t1.start();
		t2.start();
	}

}
class MyTest1{
	static MyTest1 obj;
	private MyTest1() {
		System.out.println("My Test Singleton");
	}
	public static MyTest1 getInstace() {
		if(obj == null)
			synchronized (MyTest1.class) {
				if(obj == null)
				obj = new MyTest1();
			}
		
		return obj;
	}
}
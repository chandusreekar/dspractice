package com.stream.com.singleton.designpattern;

public class MySingleton {

	public static void main(String[] args) {
//		MySingletonTest obj1 = MySingletonTest.getInstance();
//		MySingletonTest obj2 = MySingletonTest.getInstance();
//		if(obj1 == obj2)
//			System.out.println("Reffering to the same obj");
//		else
//			System.out.println("Not a same obj");
		SingletonDemo obj1 = SingletonDemo.getInstance();
		System.out.println(obj1);
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				MySingletonTest obj1 = MySingletonTest.getInstance();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				MySingletonTest obj2 = MySingletonTest.getInstance();
				
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.setDaemon(true);
			t2.setDaemon(true);
		} catch (Exception e) {
			
		}
		

	}

}
class MySingletonTest{
//	static MySingletonTest obj = new MySingletonTest();
	static MySingletonTest obj;
	private MySingletonTest() {
		System.out.println("This is a Singleton Class");
	}
	public static MySingletonTest getInstance() {
		if(obj == null)
			synchronized(MySingletonTest.class) {
				if(obj == null)
					obj = new MySingletonTest();
				System.out.println("It's a Singleton class");
			}		
		return obj;
	}
}	
class SingletonDemo{
	static SingletonDemo object1;
	private SingletonDemo() {
		System.out.println("My Demo");
	}
	
	public static SingletonDemo getInstance() {
		if(object1 == null) {
			synchronized(SingletonDemo.class) {
				if(object1 == null) {
					object1 = new SingletonDemo();
				}
			}
		}
		return object1;
	}
	

}
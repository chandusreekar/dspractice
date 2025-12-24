package com.stream.com.singleton.designpattern;

public class Singleton1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Test obj = Test.getInstance();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Test obj = Test.getInstance();
			}
		});
		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		t2.start();
	}
}

class Test{
	public static Test obj;
	private Test() {
		if(obj != null) {
		throw new RuntimeException("Use Instance method reflection not allowed");
		}
	}
	public static Test getInstance() { // Double Checked Locking mechanism
		if(obj == null) {	
			synchronized (Test.class) {
				if(obj == null)
				obj = new Test();
			}
			
		}
		return obj;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return new CloneNotSupportedException("Not Support Cloning");
	}
	
}
package com.stream.test;

public class SingletonThrdSafe {
  private static volatile SingletonThrdSafe instance;
  
  private SingletonThrdSafe() {}
  
  public static SingletonThrdSafe getInsatnce() {
	  
	  if(instance == null) {
		  synchronized (SingletonThrdSafe.class) {
			if(instance == null) {
				instance = new SingletonThrdSafe();
			}
		}
	  }
	  return instance;
  }
  
}

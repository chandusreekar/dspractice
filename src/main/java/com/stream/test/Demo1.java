package com.stream.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface A {
    default void test() {
        System.out.println("A's default test");
    }
}

interface B {
	void add();
    void test1(); // abstract
    default void test() {
        System.out.println("B's default test");
    }
    
    static void mul() {
    	
    }
}

class Test1 implements A, B {
    @Override
    public void test() {
        // You can call A's default if needed
        A.super.test();
        System.out.println("Test class vxzzimplementation");
    }

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}
}

public class Demo1 {

	public static void main(String[] args) {
		Test1 test = new Test1();
		test.test();
		

		
		
//		Map<String,List<Employee>> deptWiseEmployeeMap = list.stream().collect(Collectors.groupingBy(Employee::getDept));
		
//		System.out.println(deptWiseEmployeeMap);
	
		// 2nd high
		
		int[] arr = {10,30,20,50,60,50,60,40};
		int fMax = Integer.MIN_VALUE;
		int sMax = Integer.MIN_VALUE;
		
		for(int n: arr) {
			if(n > fMax) {
				sMax = fMax;
				fMax = n;
			}else if(n > sMax && n != fMax) {
				sMax = n;
			}
		}
	
		System.out.println("Second max: "+sMax);
	

	}

}

package com.stream.com.test.statemets;

import java.util.Arrays;
import java.util.List;

public class ForLoopEx1 {

	public static void main(String[] args) {
		
	/*	int j = 4;
		
//		for(initilaztion; condition; increment/decrement)
		for(int i=0; i<=5;i++) {
			if(j==3) {
				System.out.println("Welcome to the Ashwik Technologies" + i);
			}
		*/
	/*
	 * for(int i=1;i<=5;i++){ // 1; 1+1 =2; 2+1 = 3; for(int j=5;j>=i;j--){ // 5;
	 * 5-1=4; 4-1=3;3-1=2; 1>=1 D D D D D System.out.print("D "); }
	 * System.out.println();//new line }
	 */
		
		for(int i= 1; i<=10; i++) {
			if(i%2==0) {
				System.out.println(i + " Even number");
			}else {
				System.out.println(i+" Odd number ");
			}
		}
		
		
		List<Integer> list = Arrays.asList(12,23,44,56,78);
		
		for(int i :list) {
			System.out.println(i);
		}
		
		 list.stream().filter(a->a%2==0).forEach(System.out::print);
		
		
	}

}

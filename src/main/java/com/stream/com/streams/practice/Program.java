package com.stream.com.streams.practice;

import java.util.*;
import java.util.Comparator;

public class Program {

	public static void main(String[] args) {
		String s1 ="I am learning Stream API in Java";
		
		String ans = Arrays.stream(s1.split(" "))
								.max(Comparator.comparing(String::length)).get();
		System.out.println(ans);

	}

}

package com.stream.com.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapTestStream {

	public static void main(String[] args) {
		  Map map=new HashMap();  
		    //Adding elements to map  
		    map.put(1,"Amit");  
		    map.put(5,"Rahul");  
		    map.put(2,"Jai");  
		    map.put(6,"Amit"); 
		    
		    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
		    System.out.println("+++++++++");
		    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

	}

}

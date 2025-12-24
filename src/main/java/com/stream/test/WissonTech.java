package com.stream.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WissonTech {

	public static void main(String[] args) {
		int[] prices = {100, 180, 260, 310, 40, 535, 695, 30};
		
		var res = Arrays.stream(prices).summaryStatistics();
		int min = res.getMin();
		int max = res.getMax();
		int maxLoss = max - min;
		System.out.println("Max Loss "+maxLoss);
		
		
		
		int n = prices.length-1;
//		int min = prices[0];
//		int max = prices[n]
		
		int[] newArr = new int[prices.length];
		for(int i = 0; i<n; i++){
		    for(int j = i+1; j<n; j++){
		        
		        if(prices[i] < prices[j]){
		            max = min; 
		            
		        }
		        
		    }
		}
	}

}

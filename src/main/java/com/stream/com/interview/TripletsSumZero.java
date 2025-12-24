package com.stream.com.interview;

import java.util.*;

public class TripletsSumZero {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        
        var finalRes = new ArrayList<>();
        for(int i=0; i< n-2; i++)
        	for(int j= i+1; j< n-1; j++ )
        		for(int k = j+1; k<n; k++)
        			if(arr[i]+arr[j]+arr[k] ==0) {
        				var triplet = Arrays.asList(arr[i], arr[j], arr[k]);
        				finalRes.add(triplet);
        			}
        
        
        System.out.println(finalRes);
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (arr[i] + arr[j] + arr[k] == 0) {
//                        List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
//                        
//                        result.add(triplet);
//
////                         To avoid duplicates
////                        Collections.sort(triplet);
////                        if (!result.contains(triplet)) {
////                            result.add(triplet);
////                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(result);
    }
}

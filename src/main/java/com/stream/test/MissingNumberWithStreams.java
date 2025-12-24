package com.stream.test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class MissingNumberWithStreams {
    public static void main(String[] args) {
        int[] arr = {5, 8, 10, 9, 6};

        int misNum = IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()).sum() - Arrays.stream(arr).sum();
        System.out.println(misNum);
        
        // Get min & max using summary statistics
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
        int min = stats.getMin();
        int max = stats.getMax();
        System.out.println(min +"  "+max);
        int sum = 0;
        for(int i = min; i<=max; i++) {
        	sum = min+max;
//        	System.out.println(sum);
        }
        System.out.println("Sum of Numbers "+sum);
        // Expected sum from min..max
        int expectedSum = IntStream.rangeClosed(min, max).sum();
        System.out.println(expectedSum);
        // Actual sum
        int actualSum = Arrays.stream(arr).sum();

        int missing = expectedSum - actualSum;

        System.out.println("Missing Number: " + missing);
        
        int[] arr1 = {5, 8, 10, 9, 6};

        int missing1 = IntStream.rangeClosed(Arrays.stream(arr1).min().getAsInt(),
                                            Arrays.stream(arr1).max().getAsInt())
                               .sum()
                        - Arrays.stream(arr1).sum();

        System.out.println("Missing Number1: " + missing1);
        
        int[] arr2 = {10, 5, 0, -3, -30};
        
        var maxMulNum = IntStream.range(0, arr2.length).flatMap(i -> IntStream.range(i+1, arr2.length).map(j -> arr2[i]*arr2[j])).max();
        System.out.println(maxMulNum);
        
        var maxAddNum = IntStream.range(0, arr2.length).flatMap(i -> IntStream.range(i+1, arr2.length).map(j -> arr2[i]+arr2[j])).max();
        System.out.println(maxAddNum);

    }
}

package com.stream.com.interview;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class MissingNumberWithStreams {
    public static void main(String[] args) {
        int[] arr = {5, 8, 10, 9, 6};

        IntSummaryStatistics st = Arrays.stream(arr).summaryStatistics();
        int mn = st.getMin();
        int mx = st.getMax();
        
        int expSum = IntStream.rangeClosed(mn, mx).sum();
        
        int actSum = Arrays.stream(arr).sum();
        
        int sum = Arrays.stream(arr).reduce((e1, e2) -> e1+e2).getAsInt();
        int m = sum/arr.length;
        System.out.println(m);
        
        int missingNum = expSum - actSum;
        System.out.println(missingNum);
        
        
        int miss = IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()).sum() - Arrays.stream(arr).sum();
        
        int missing = IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()).sum() - Arrays.stream(arr).sum();
        
        System.out.println(missing);
    }
}

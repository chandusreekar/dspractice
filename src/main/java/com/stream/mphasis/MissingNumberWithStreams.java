package com.stream.mphasis;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
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

        List<Integer> list = Arrays.asList(1,2,3,4,6,7,8,9);

        int missNumb = IntStream.rangeClosed(list.stream().mapToInt(Integer::intValue).min().getAsInt(), list.stream().mapToInt(Integer::intValue).max().getAsInt()).sum() - list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Missing Number Using list of Stream (List) missNumb : "+missNumb);

        List<Integer> list1 = Arrays.asList(5, 8, 10, 9, 6);
        int missNumb1 = IntStream.rangeClosed(list1.stream().mapToInt(Integer::intValue).min().getAsInt(), list1.stream().mapToInt(Integer::intValue).max().getAsInt()).sum() - list1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Missing Number Using list of Stream (List1) missNumb1 : "+missNumb1);

        // Using Java 7 Programming

        //{5, 8, 10, 9, 6};
        int min = arr[0];
        int max = arr[0];
        int exSum = 0;
        for(int no : arr){
            if(no < min) min = no;
            if(no > max) max = no;
            exSum = exSum + no;
        }

        int acSum = 0;
        for(int i = min; i<= max; i++){
            acSum = acSum + i;
        }

        int misNum = acSum - exSum;
        System.out.println("Missing Number In an unsorted Array :"+misNum);

        // This logic only for sorted array or list

        int n = list.size() + 1;
        int expectedSum = n * (n + 1) / 2; //45

        int actualSum = 0; //40
        for (int num : list) {
            actualSum += num;
        }

        System.out.println("Missing number: " + (expectedSum - actualSum));

    }
}

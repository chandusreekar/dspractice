package com.stream.mphasis;

import java.util.*;

public class MissingNumberJava7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,6,7,8,9);

        int n = list.size() + 1;
        int expectedSum = n * (n + 1) / 2; //45

        int actualSum = 0; //40
        for (int num : list) {
            actualSum += num;
        }

        System.out.println("Missing number: " + (expectedSum - actualSum));
    }
}

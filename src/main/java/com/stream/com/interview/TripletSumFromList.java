package com.stream.com.interview;
import java.util.*;

public class TripletSumFromList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, -1, 2, -3, 1);
        int n = list.size();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = list.get(i);
                    int b = list.get(j);
                    int c = list.get(k);

                    if (a + b + c == 0) {
                        List<Integer> triplet = Arrays.asList(a, b, c);

                        // Sort and avoid duplicates
                        List<Integer> sortedTriplet = new ArrayList<>(triplet);
                        Collections.sort(sortedTriplet);

                        if (!result.contains(sortedTriplet)) {
                            result.add(sortedTriplet);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}

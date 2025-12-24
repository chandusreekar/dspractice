package com.stream.com.interview;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class MaxProduct {
    public static void main(String[] args) {
        int arr[] = {10, 5, 0, -3, -30};
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int product = arr[i] * arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        int maxProductStream = IntStream.range(0, arr.length)
                .flatMap(i -> IntStream.range(i + 1, arr.length)
                        .map(j -> arr[i] * arr[j]))
                .max()
                .orElse(Integer.MIN_VALUE);
        
        int maxProductList = Arrays.stream(arr)
                .boxed()
                .flatMap(a -> Arrays.stream(arr)
                        .boxed()
                        .filter(b -> !Objects.equals(a, b)) // avoid self-pairing
                        .map(b -> a * b))
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        System.out.println("Maximum Product of Two Elements: " + maxProductList);
        System.out.println("Maximum Product of Two Elements: " + maxProduct);
        System.out.println("Maximum Product of Two Elements: " + maxProductStream);
    }
}

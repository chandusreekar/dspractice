package com.stream.com;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 2;

        int n = arr.length;
        k = k % n; // incase k is > n
        
        int[] rightRotated = IntStream.concat(Arrays.stream(arr, n-k, n), Arrays.stream(arr, 0, n-k)).toArray();
        System.out.println(Arrays.toString(rightRotated));
        
        int[] leftRotated = IntStream.concat(Arrays.stream(arr, k,n), Arrays.stream(arr, 0, k)).toArray();
        System.out.println(Arrays.toString(leftRotated));
        
        int[] newArr = new int[n];
        for(int i = 0; i<n; i++) {
        	newArr[i] = arr[(i+k)%n];
        }
        System.out.println(Arrays.toString(newArr));
    }
}

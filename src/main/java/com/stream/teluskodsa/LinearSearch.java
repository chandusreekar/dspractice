package com.stream.teluskodsa;

public class LinearSearch {

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = linearSearch(arr, target);

        if(result != -1){
            System.out.println("Element  found at Index : "+result);
        }
        else {
            System.out.println("Element not found");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }

        }
        return -1;
    }

}


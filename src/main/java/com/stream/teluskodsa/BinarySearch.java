package com.stream.teluskodsa;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int left = 0;
        int right = arr.length - 1 ;

        int result = binarySearchTest(arr, target);
        int result1 = binarySearchTest1(arr, target, left, right);
        if(result != -1){
            System.out.println("Element  found at Index : "+result);
        }
        else {
            System.out.println("Element not found");
        }

        if(result1 != -1){
            System.out.println("Element  found at Index Rec : "+result1);
        }
        else {
            System.out.println("Element not found");
        }
    }

    public static int binarySearchTest1(int[] arr, int target, int left, int right) {

        if(left <= right){
           int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchTest1(arr, target, mid+1, right);
            } else {
                return binarySearchTest1(arr, target, left, mid-1);
            }
        }
        return -1;
    }

    public static int binarySearchTest(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1 ;
        int mid;
        while(left <= right){
            mid = (left+right)/2;

            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

package com.stream.teluskodsa;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {6,3,5,9,4,8,1};
        int temp =0;
//        for(int i = 0; i< arr.length; i++){
//            for(int j = i+1; j<arr.length; j++){
//                if(arr[i] > arr[j]){
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int nums : arr){
            System.out.print(nums +" ");
        }
    }
}

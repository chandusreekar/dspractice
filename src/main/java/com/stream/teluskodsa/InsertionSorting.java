package com.stream.teluskodsa;

public class InsertionSorting {
    public static void main(String[] args) {
        int arr[] = {3,1,5,9,6,2,7};
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]> key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int nums : arr){
            System.out.print(nums +" ");
        }
    }
}

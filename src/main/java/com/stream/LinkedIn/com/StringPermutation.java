package com.stream.LinkedIn.com;

import java.util.Scanner;

public class StringPermutation {

	public static String stringPermutation(String str, int i, int j) {

		char[] arr = str.toCharArray();
		char ch;
		ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;

		return String.valueOf(arr);
	}

	public static void calculatePermutation(String str, int i, int j) {

		if (i == j - 1) {
			System.out.println("S -> : "+str);
		} else {
			for (int k = i; k < j; k++) {
				str = stringPermutation(str, i, k);
				calculatePermutation(str, i + 1, j);
				str = stringPermutation(str, i, k);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = sc.nextLine();
		int size = str.length();
		calculatePermutation(str, 0, size);

		sc.close();
	}

}
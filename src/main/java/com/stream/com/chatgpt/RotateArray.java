package com.stream.com.chatgpt;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArray {
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		int k = 5; // number of elements to rotate

		int n = input.length;
		int[] rotated = new int[n];

		for (int i = 0; i < n; i++) {
			rotated[i] = input[(i + k) % n];
		}

		System.out.println(Arrays.toString(rotated));
		List<String> list = Arrays.asList("ram", "sita", "rahul", null, null, "deepak");

		var response = Stream.concat(list.stream().filter(Objects::isNull), list.stream().filter(Objects::nonNull))
				.collect(Collectors.toList());
		System.out.println(response);
		
		int x = 2;
		for(int i=0;i<n;i++) {
			rotated[i] = input[(i+x)%n];
		}
		System.out.println(Arrays.toString(rotated));
		
		var res = Stream.concat(list.stream().filter(Objects::nonNull), list.stream().filter(Objects::isNull)).collect(Collectors.toList());
		System.out.println(res);
	}
}

// [3, 4, 5, 1, 2]

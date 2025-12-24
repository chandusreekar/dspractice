package com.stream.com.practice;

import java.util.stream.IntStream;

public class MaxProductWithStreams {

	public static void main(String[] args) {
		int[] arr = {10, 5, 0, -3, -30};
		int maxvalue = IntStream.range(0, arr.length)
				.flatMap(i -> IntStream.range(i+1, arr.length).map(j -> arr[i] * arr[j]))
				.max().orElse(Integer.MIN_VALUE);
		System.out.println(maxvalue);
		}

}

package com.stream.mphasis;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonrepeatedChars {
    public static void main(String[] args) {
        String input = "Java Program is Good";

        var res = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.print(res);

    }
}

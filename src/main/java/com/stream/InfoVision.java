package com.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InfoVision {
    public static void main(String[] args) {
        String str = "throot";

        var res = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1).map(e -> e.getKey()).findFirst().get();
        System.out.println(res);
    }

}

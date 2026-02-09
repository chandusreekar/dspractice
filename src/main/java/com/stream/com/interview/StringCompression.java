package com.stream.com.interview;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbaacccc";

        ConcurrentMap<Object, List<Character>> result = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(i))   // convert to Stream<Character>
                .collect(Collectors.groupingByConcurrent(
                        c -> new Object() {
                            int index = str.indexOf(c);
                        }
                ));
        System.out.println(result);

        
        String str1 = "Java programming";
        
       var result1 =  str1.chars().mapToObj(c -> (char) c)
        .map(Character::toLowerCase)
        .filter(c -> c != ' ') 
        .collect(Collectors.toCollection(LinkedHashSet::new))
        .stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
        	Collections.reverse(list);
        	return list.stream().map(String::valueOf)
        			.collect(Collectors.joining());
        }));
       
       System.out.println(result1);
       
        // ✅ Easier way using simple loop + streams for cleaner solution
//        String compressed = compress(str);
//        System.out.println(compressed);
    }

    // Simple method using Streams-like idea
//    public static String compress(String str) {
//        StringBuilder sb = new StringBuilder();
//
//        IntStream.range(0, str.length())
//                .forEach(i -> {
//                    if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
//                        sb.append(str.charAt(i)).append(1);
//                    } else {
//                        int lastIndex = sb.length() - 1;
//                        sb.replace(lastIndex, lastIndex + 1,
//                                String.valueOf((sb.charAt(lastIndex) - '0') + 1));
//                    }
//                });
//
//        return sb.toString();
//    }
}

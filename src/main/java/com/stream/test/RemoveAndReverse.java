package com.stream.test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveAndReverse {
    public static void main(String[] args) {
        String str = "Programming";
//        String str = "Java programming";
        String s = new StringBuilder(str.replace("ram", "")).reverse().toString();
        System.out.println(s);
        StringBuffer s1 = new StringBuffer(str.replace("ram", "")).reverse();
        System.out.println(s1);
        var rmStr = str.replace("ram", "");
//        		.chars().mapToObj(c -> (char)c).filter(c -> c != ' ').map(String::valueOf).collect(Collectors.joining());
        System.out.println(rmStr);
        String reversed = IntStream.range(0, rmStr.length()).mapToObj(i -> rmStr.charAt(rmStr.length() - 1 - i)).map(String::valueOf)
        		.collect(Collectors.joining());

        System.out.println("Original   : " + str);
        System.out.println("After step : " + rmStr);
        System.out.println("Final out  : " + reversed);
        
        
        String rev = "";
        for(int i = str.length()-1; i >=0; i--) {
        	rev = rev + str.charAt(i);
//        	System.out.println("Rev :"+rev);
        }
        System.out.println("Rev : "+rev);
    }
}

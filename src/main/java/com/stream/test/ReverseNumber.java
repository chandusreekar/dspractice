package com.stream.test;

import java.time.LocalDate;
import java.time.Period;

public class ReverseNumber {
    public static void main(String[] args) {
        int input = 12345;
        int reversed = 0;

        while (input != 0) {
            reversed = reversed * 10 + input % 10;;
            input = input / 10;
        }

        System.out.println("Reversed Number: " + reversed);
        
        LocalDate birthday = LocalDate.of(1994, 12, 7);
        Period age = Period.between(birthday, LocalDate.now());
        System.out.println(age.getYears());
    }
}

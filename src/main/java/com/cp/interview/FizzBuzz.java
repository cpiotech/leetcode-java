package com.cp.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by curry on 4/18/17.
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> {
            String s = "";
            if (i % 3 == 0) {
                s+= "Fizz";
            }
            if (i % 5 == 0) {
                s+= "Buzz";
            }

            if (s.length() > 0) {
                result.add(s);
            } else {
                result.add(String.valueOf(i));
            }
        });
        return result;
    }
    public static void main(String[] args) {
        fizzBuzz(15).forEach(r -> System.out.println(r));
    }
}

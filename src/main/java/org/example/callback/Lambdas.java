package org.example.callback;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> toUpperCase1 = String::toUpperCase; /* name -> name.toUpperCase() */

        Function<String, String> toUpperCase2 = name -> {
            if (name.isEmpty()) throw new IllegalArgumentException();
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> toUpperCase3 = (name, age) -> {
            if (name.isEmpty()) throw new IllegalArgumentException();
            return name.toUpperCase() + age.toString();
        };

        System.out.println(toUpperCase1.apply("Alex")); // ALEX
        System.out.println(toUpperCase2.apply("Alex")); // ALEX
//        System.out.println(toUpperCase2.apply("")); // Throws exception
        System.out.println(toUpperCase3.apply("Alex", 13)); // ALEX13
    }
}

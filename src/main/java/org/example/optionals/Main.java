package org.example.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Object value1 = Optional.ofNullable(null)
                .orElseGet(() -> "Default value");

        Object value2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "Default value");

//        Object value3 = Optional.ofNullable(null)
//                .orElseThrow(() -> new IllegalStateException());

        Optional.ofNullable("Hello")
                .ifPresent(value -> System.out.println(value + ", World!")); // Hello, World!

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        value -> System.out.println(value + ", World!"),
                        () -> System.out.println("Variable is null")
                        ); // Variable is null

        System.out.println(value1); // Default value
        System.out.println(value2); // Hello
//        System.out.println(value3); // exception thrown
    }
}

package org.example.functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println("\n***Function***"); // Takes 1 argument and produces 1 result

        int increment = incrementByOne(1);
        System.out.println(increment); // 2

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2); // 2

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply); // 20

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4)); // 50


        System.out.println("\n***BiFunction***"); // Takes 2 arguments and produces 1 result

        System.out.println(incrementByOneAndMultiply(4, 100)); // 500

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100)); // 500
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return ++number;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> ++numberToIncrementByOne * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return ++number * numToMultiplyBy;
    }

}

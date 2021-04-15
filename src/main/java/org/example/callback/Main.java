package org.example.callback;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        System.out.println("***With Consumer***");

        hello1("John", "Montana", firstName ->
                System.out.println("Last name not provided for " + firstName)); // John Montana

        hello1("John", null, firstName ->
                System.out.println("Last name not provided for " + firstName)); // Last name not provided for John


        System.out.println("***With Runnable***");

        hello2("John", "Montana", () -> System.out.println("Last name not provided")); // John Montana

        hello2("John", null, () -> System.out.println("Last name not provided")); // Last name not provided
    }

    static void hello1(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}

package org.example.combinator_pattern;

import java.time.LocalDate;

import static org.example.combinator_pattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer(
                "Alice",
                "avb@gmail.com",
                "+380996611650",
                LocalDate.of(2000, 1, 1));

        Customer customer2 = new Customer(
                "Alice",
                "avbgmail.com",
                "+380996611650",
                LocalDate.of(2000, 1, 1));

        System.out.println("\n***Common approach***");

        System.out.println(new CustomerValidatorService().isValid(customer1)); // true
        System.out.println(new CustomerValidatorService().isValid(customer2)); // false


        System.out.println("\n***Combinator pattern***");

        ValidationResult result1 = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer1);
        ValidationResult result2 = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer2);

        System.out.println(result1); // SUCCESS
        System.out.println(result2); // EMAIL_NOT_VALID

        if (result1 != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result1.name());
        }

        if (result2 != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result2.name());
        } // throws exception
    }
}

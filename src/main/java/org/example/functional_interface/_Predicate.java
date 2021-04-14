package org.example.functional_interface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("\n***Predicate***"); // Takes 1 argument and produces 1 result

        System.out.println(isPhoneNumberValid("+380996616650")); // true
        System.out.println(isPhoneNumberValid("+381996616650")); // false
        System.out.println(isPhoneNumberValid("+3809966166500")); // false
        System.out.println(isPhoneNumberValidPredicate.test("+380996616650")); // true
        System.out.println(isPhoneNumberValidPredicate.test("+381996616650")); // false
        System.out.println(isPhoneNumberValidPredicate.test("+3809966166500")); // false

        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("+380996616650")); // true
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("+3819966166500")); // false
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("+3809966166500")); // false

        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("+380996616650")); // true
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("+3819966166500")); // true
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("+3809966166500")); // true

        System.out.println("\n***BiPredicate***"); // Takes 2 argument and produces 1 result
        // Same
    }

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("+380") && phoneNumber.length() == 13;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("+380") &&
            phoneNumber.length() == 13;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}

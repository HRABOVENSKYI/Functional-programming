package org.example.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static org.example.streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );


        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println); // MALE FEMALE


        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length; /* name -> name.length() */
        IntConsumer println = System.out::println; /* s -> System.out.println(s) */

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println); // 4 5 5 4 5


        Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);

        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);

        boolean containsFemales = people.stream()
                .anyMatch(personPredicate);

        boolean noFemales = people.stream()
                .noneMatch(personPredicate);

        System.out.println(containsOnlyFemales); // false
        System.out.println(containsFemales); // true
        System.out.println(noFemales); // false
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

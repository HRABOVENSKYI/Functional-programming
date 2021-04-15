package org.example.beginning.declarative;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.example.beginning.declarative.Main.Gender.FEMALE;
import static org.example.beginning.declarative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        System.out.println("***Declarative approach***");

        // Find and log all females
        Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);

        List<Person> females = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females.forEach(System.out::println);
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

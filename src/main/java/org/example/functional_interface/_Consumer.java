package org.example.functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        System.out.println("\n***Consumer***"); // Takes 1 argument and produces 1 result

        Customer maria = new Customer("Maria", "+380996616650");

        greetCustomer(maria); // Hello Maria, thanks for registering phone number +380996616650
        greetCustomerConsumer.accept(maria); // Hello Maria, thanks for registering phone number +380996616650


        System.out.println("\n***BiConsumer***"); // Takes 2 argument and produces 1 result

        greetCustomerV2(maria, true); // Hello Maria, thanks for registering phone number +380996616650
        greetCustomerV2(maria, false); // Hello Maria, thanks for registering phone number +380*********
        greetCustomerConsumerV2.accept(maria, true); // Hello Maria, thanks for registering phone number +380996616650
        greetCustomerConsumerV2.accept(maria, false); // Hello Maria, thanks for registering phone number +380*********
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println(
            "Hello " + customer.customerName + ", thanks for registering phone number " +
            (showPhoneNumber ? customer.customerPhoneNumber : "+380*********"));

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "+380*********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}

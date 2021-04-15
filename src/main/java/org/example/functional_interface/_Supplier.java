package org.example.functional_interface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println("\n***Supplier***"); // Takes 1 argument and produces 1 result

        System.out.println(getDBConnectionUrl()); // jdbc://localhost:5432/users
        System.out.println(getDBConnectionUrlSupplier.get()); // jdbc://localhost:5432/users
        System.out.println(getDBConnectionUrlSupplier2.get()); // [jdbc://localhost:5432/users, jdbc://localhost:5432/customer]
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlSupplier2 = () -> List.of("jdbc://localhost:5432/users",
            "jdbc://localhost:5432/customer");
}

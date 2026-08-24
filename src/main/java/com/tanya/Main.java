package com.tanya;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                LocalDate.of(2025, 2, 1),
                "Samsung Corp.",
                "Korea",
                5599.0,
                true
        );

        productsArray[1] = new Product(
                "iPhone 16",
                LocalDate.of(2024, 9, 20),
                "Apple",
                "США",
                99999.0,
                false
        );

        productsArray[2] = new Product(
                "Xiaomi 15",
                LocalDate.of(2025, 3, 1),
                "Xiaomi",
                "Китай",
                69999.0,
                false
        );

        productsArray[3] = new Product(
                "Galaxy Watch",
                LocalDate.of(2025, 1, 15),
                "Samsung",
                "Korea",
                25000.0,
                true
        );

        productsArray[4] = new Product(
                "MacBook Air",
                LocalDate.of(2025, 3, 10),
                "Apple",
                "США",
                120000.0,
                false
        );
        for (Product product : productsArray) {
            product.printInfo();
        }
        Park park = new Park();

        Park.Attraction attraction = park.new Attraction(
                "Американские горки",
                "10:00 - 22:00",
                1500.0
        );
        attraction.printInfo();
    }
}

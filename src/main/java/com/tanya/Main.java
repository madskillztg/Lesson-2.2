package com.tanya;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumInRange(5, 10));
        checkNumber(-10);
        System.out.println(isNegative(-10));
        printString("Hello", 5);
        System.out.println(isLeapYear(2024));
        invertArray();
    }
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign() {
        int a = 10;
        int b = -5;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = 50;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = 10;
        int b = 5;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    public static void checkNumber(int number) {

        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }

    }
    public static boolean isNegative(int number) {

        if (number < 0) {
            return true;
        } else {
            return false;
            }

        }
    public static void printString(String text, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    public static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
        public static void invertArray() {
            int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else {
                    array[i] = 0;
                }
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }





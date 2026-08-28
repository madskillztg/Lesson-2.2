package com.tanya;

public class Comparator {

    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        System.out.println(compare(3, 5));
        System.out.println(compare(5, 5));
        System.out.println(compare(7, 5));
    }
}

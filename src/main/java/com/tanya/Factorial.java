package com.tanya;

public class Factorial {

    public static long calculate(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
}

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate(5));
    }
}
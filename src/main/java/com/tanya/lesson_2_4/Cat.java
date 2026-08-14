package com.tanya.lesson_2_4;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean full;

    public Cat(String name) {
        super(name);
        catCount++;
        full = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= 10) {
            bowl.decreaseFood(10);
            full = true;
        }
    }

    public boolean isFull() {
        return full;
    }

    public static int getCatCount() {
        return catCount;
    }
}

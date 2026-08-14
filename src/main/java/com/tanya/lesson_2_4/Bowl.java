package com.tanya.lesson_2_4;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }

    public void decreaseFood(int amount) {
        if (amount > 0 && amount <= food) {
            food -= amount;
        }
    }
}

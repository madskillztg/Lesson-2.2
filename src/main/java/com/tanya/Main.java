package com.tanya;

import com.tanya.lesson_2_4.Animal;
import com.tanya.lesson_2_4.Bowl;
import com.tanya.lesson_2_4.Cat;
import com.tanya.lesson_2_4.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        Bowl bowl = new Bowl(20);
        Bowl smallBowl = new Bowl(5);

        catBarsik.eat(smallBowl);

        System.out.println("Барсик сыт: " + catBarsik.isFull());
        System.out.println("Еды в маленькой миске: " + smallBowl.getFood());

        System.out.println("Мурзик сыт: " + catMurzik.isFull());

        catMurzik.eat(bowl);

        System.out.println("Мурзик сыт: " + catMurzik.isFull());
        System.out.println("Еды в миске: " + bowl.getFood());

        bowl.addFood(15);
        System.out.println("Еды в миске после добавления: " + bowl.getFood());

        dogBobik.swim(15);
        catMurzik.run(250);
        catMurzik.swim(10);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Котов создано: " + Cat.getCatCount());
    }
}



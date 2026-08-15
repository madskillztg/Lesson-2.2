package com.tanya;

import com.tanya.lesson_2_4.Animal;
import com.tanya.lesson_2_4.Bowl;
import com.tanya.lesson_2_4.Cat;
import com.tanya.lesson_2_4.Dog;
import com.tanya.lesson_2_4.figures.Circle;
import com.tanya.lesson_2_4.figures.Rectangle;
import com.tanya.lesson_2_4.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        Circle circle = new Circle(5, "красный", "чёрный");
        Rectangle rectangle = new Rectangle(10, 5, "синий", "зелёный");
        Triangle triangle = new Triangle(3, 4, 5, "жёлтый", "чёрный");

        System.out.println("Круг:");
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());

        System.out.println("Прямоугольник:");
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());

        System.out.println("Треугольник:");
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());

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



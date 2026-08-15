package com.tanya.lesson_2_4.figures;

public interface Figure {
    double getArea();

    String getFillColor();

    String getBorderColor();

    default double getPerimeter() {
        return 0;
    }
}

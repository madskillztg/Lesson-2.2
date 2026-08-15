package com.tanya.lesson_2_4.figures;

public class Triangle implements Figure {

    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(
                halfPerimeter
                        * (halfPerimeter - sideA)
                        * (halfPerimeter - sideB)
                        * (halfPerimeter - sideC)
        );
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

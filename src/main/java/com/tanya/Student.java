package com.tanya;

import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void promoteToNextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }
}

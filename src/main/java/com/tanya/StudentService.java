package com.tanya;

import java.util.Set;

public class StudentService {

    public void removeStudentsWithLowAverage(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            student.promoteToNextCourse();
        }
    }

    public void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}

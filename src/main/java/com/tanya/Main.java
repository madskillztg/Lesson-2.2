package com.tanya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Анна",
                "Группа 1",
                2,
                Arrays.asList(5, 4, 5)
        ));

        students.add(new Student(
                "Иван",
                "Группа 1",
                2,
                Arrays.asList(2, 3, 2)
        ));

        students.add(new Student(
                "Олег",
                "Группа 2",
                3,
                Arrays.asList(4, 4, 3)
        ));

        StudentService studentService = new StudentService();

        System.out.println("Студенты до удаления:");
        studentService.printStudents(students, 2);

        studentService.removeStudentsWithLowAverage(students);

        System.out.println("Студенты после удаления:");
        studentService.printStudents(students, 2);

        studentService.promoteStudents(students);

        System.out.println("Студенты после перевода на следующий курс:");
        studentService.printStudents(students, 3);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89991112233");
        phoneBook.add("Иванов", "89994445566");
        phoneBook.add("Петров", "89997778899");

        System.out.println("Телефоны Иванова:");
        System.out.println(phoneBook.get("Иванов"));

        System.out.println("Телефоны Петрова:");
        System.out.println(phoneBook.get("Петров"));
    }
}

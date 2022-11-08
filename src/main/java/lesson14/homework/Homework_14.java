package lesson14.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//First level: Есть класс Student name, age, speciality и класс Professor имя,
// зарплата и список его студентов.
// Напишите геттеры, сеттеры и конструеторы, а также Comparator для преподавателя по числу его студентов.
//
//
//Second level: -
public class Homework_14 {
    public static void main(String[] args) {
        Student s1 = new Student("Max Kotkov", 25, "music");
        Student s2 = new Student("Masha Smirnova", 22, "physics");
        Student s3 = new Student("Sam Smith", 21, "persian");

        Professor p1 = new Professor("Laslo Perez", 35_000);
        p1.addStudent(s1);
        p1.addStudent(s3);
        Professor p2 = new Professor("John Smith", 45_000);
        p2.addStudent(s2);
        Professor p3 = new Professor("Smith", 45_000);
        p3.addStudent(s2);
        p3.addStudent(s1);
        p3.addStudent(s3);
        Professor p4 = new Professor("J", 45_000);


        List<Professor> professors = new ArrayList<>();
        professors.add(p1);
        professors.add(p2);
        professors.add(p3);
        professors.add(p4);
        Collections.sort(professors);
        System.out.println(professors);
        Collections.sort(professors, (o1, o2) -> Integer.compare(o1.getStudents().size(), o2.getStudents().size()));
        System.out.println(professors);
        Collections.sort(professors);
        System.out.println(professors);
        Collections.sort(professors, Comparator.reverseOrder()); // Comparable
        System.out.println(professors);
    }
}

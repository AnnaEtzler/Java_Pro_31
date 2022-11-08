package lesson14.homework;

import java.util.ArrayList;
import java.util.List;

// Есть класс Student name, age, speciality и класс Professor имя, зарплата и список его студентов.
// Напишите геттеры, сеттеры и конструеторы, а также Comparator для преподавателя по числу его студентов.
public class Professor implements Comparable<Professor> {
    private String name;
    private  int salary;
    private List<Student> students = new ArrayList<>();

    public Professor(String name, int salary) {
        this.name = name;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", students=" + students.size() +
                '}';
    }

    public void addStudent(Student s){
        if(s != null){
            students.add(s);
        }


    }


    public int compareTo(Professor o) {
        return this.getStudents().size()- o.getStudents().size();
    }
}

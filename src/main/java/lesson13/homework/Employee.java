package lesson13.homework;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private int salary;


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(id, o.getId());
    }

    public static class EmployeeAgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public static class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            if(o1 == null && o2 == null)
                return 0;
            if(o1== null)
                return -1;
            if(o2 == null)
                return 1;
            if(o1.getName() == null && o2.getName() == null)
                return 0;
            if(o1.getName() == null && o2.getName() != null)
                return -1;
            return o1.getName().compareTo(o2.getName());
        }
    }

    @Override
    public String toString() {
        return "E{" +
                "i=" + id +
                ", n='" + name + '\'' +
                ", a=" + age +
                ", s=" + salary +
                '}';
    }



    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}

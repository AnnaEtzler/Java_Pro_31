package lesson13.homework;

import java.util.*;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee e1 = new Employee(2, "Sam", 33, 22_000);
        Employee e2 = new Employee(3, "John", 30, 25_000);
        Employee e3 = new Employee(3, "Alex", 33, 22_000);
        Comparator<Employee> c1 = new Employee.EmployeeNameComparator();

        System.out.println(
                c1.compare(e1,e2)
        );

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        employees.sort(Comparator.comparing(Employee::getId));

        Collections.sort(employees,
                Comparator
                        .comparing(Employee::getAge)
                        .thenComparing(Employee::getName)
        );
        System.out.println(
                employees
        );

        complexSort(employees, Arrays.asList(new Employee.EmployeeNameComparator(), new Employee.EmployeeAgeComparator()));

        genericSort(employees, Arrays.asList(new Employee.EmployeeNameComparator(), new Employee.EmployeeAgeComparator()));

        System.out.println(
                employees
        );

    }

    // Напишите функцию, которая принимает на вход список Employee и
    // список компараторов для сортировки Employee;
    // сортирует переданный List<Employee> компараторами.
    public static void complexSort(List<Employee> employees, List<Comparator<Employee>> comparators){
        Comparator<Employee> comparator = comparators.get(0);
        for (int i = 1; i < comparators.size(); i++) {
            comparator.thenComparing(comparators.get(i));
        }
        employees.sort(comparator);
    }

    public static <T>  void  genericSort(List<T> list, List<Comparator<T>> comparators)
    {
        Comparator<T> comparator = comparators.get(0);
        for (int i = 1; i < comparators.size(); i++) {
            comparator.thenComparing(comparators.get(i));
        }
        list.sort(comparator);
    }

}

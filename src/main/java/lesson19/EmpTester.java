package lesson19;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Shapovalov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manger"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Nikolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Petr Sveshnikov", 37, "programmer"),
                new Emp("Alex Con", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

        // найдите самого молодого
        employees.stream()
                .min(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);

        //Метод ifPresent() позволяет также устранить некоторую избыточность кода, следующего вида:
        //
        // if(person != null) {
        //	System.out.println(person);
        // }
        System.out.println("распечатать всех работников отсортировав их по профессии и возрасту****************************");
        // распечатать всех работников отсортировав их по профессии и возрасту
        Comparator<Emp> compName = Comparator.comparing(Emp::getName);
        Comparator<Emp> compAge = Comparator.comparing(Emp::getAge);
        employees.stream().
                sorted(compName.thenComparing(compAge))      //передаем comparator
                .forEach(System.out::println);


        System.out.println("заджойнить имена всех работников старше 36 лет через \", \"*************************");
        // заджойнить имена всех работников старше 36 лет через ", "
        String s = employees.stream()
                .filter(emp -> emp.getAge() > 36)
                .map(emp -> emp.getName())//даёт возможность создать функию с помощью которой мы будем изменять каждый элемент и пропускать его дальше
                .collect(Collectors.joining(", "));
        System.out.println(s);



        System.out.println("осчитайте сумму возрастов работников*************************************");
        // посчитайте сумму возрастов работников
        employees.stream().map(x -> x.getAge())
                .reduce((emp, emp2) -> emp+ emp2)
                .ifPresent(System.out::println);

        System.out.println("посчитайте количество программистов*************************************");
        // посчитайте количество программистов
        long result = employees.stream()
                .filter(emp -> emp.getPosition().equals("programmer"))
                .count();
        System.out.println(result);

        System.out.println("посчитайте средний возраст*************************************");
        // посчитайте средний возраст
        Optional<Integer> sum = employees.stream()
                .map(x -> x.getAge())
                .reduce((emp, emp2) -> emp + emp2);
        double res = (sum.get() / (double)(employees.stream()
                        .count()));
        System.out.println(res);

        System.out.println("разделите на две группы - старше 40 лет и младше*************************************");
        // разделите на две группы - старше 40 лет и младше
        Map<Boolean, List<Emp>> oldYoung = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));

        System.out.println("найдите профессию самого старого из молодых*************************************");
        // найдите профессию самого "старого" из "молодых"
        Stream.of(oldYoung)
                .map(x -> x.get(false))
                .sorted()
                .forEach(w -> System.out.println(w.get(w.size()-1).getPosition()));


        System.out.println("сгруппируйте по профессии*************************************");
        // сгруппируйте по профессии
        System.out.println("распечатать профессии и количество работников в ней*************************************");
        // Collectors.groupingBy(new Function<Object, Object>() {})
        // распечатать профессии и количество работников в ней


        System.out.println("средний возраст женщин" + "*************************************");
        // вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a"
        Optional<Integer> summ = employees.stream()
                .filter(x -> x.getName().endsWith("a"))
                .map(x -> x.getAge())
                .reduce((emp, emp2) -> emp + emp2);
        double avarageWoman = (summ.get() / (double)(employees.stream().filter(x -> x.getName().endsWith("a"))
                .count()));
        System.out.println(avarageWoman);


        System.out.println("средний возраст мужчин" + "*************************************");
        Optional<Integer> summ2 = employees.stream()
                .filter(emp -> emp.getName().endsWith("v"))
                .map(Emp::getAge)
                .reduce(Integer::sum);


        double avarageMan = (summ2.get() / (double)(employees.stream().filter(x -> x.getName().endsWith("v"))
                .count()));
        System.out.printf("%.2f", avarageMan);
        System.out.println();



        // распечатать работников с самым часто встречающимся возрастом
        System.out.println("распечатать работников с самым часто встречающимся возрастом*************************************");
    }

}

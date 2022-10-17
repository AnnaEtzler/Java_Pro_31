package lesson21;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentTester {
    public static void main(String[] args) {
        // Java streams: Collectors and custom Collectors
        // Collector - сгруппировать, разделить, обсчитать или сохранить в коллекцию элементы потока
        // collect() - терминальная операция потока

        // Collectors - типы
        //      Partition - передаем предикат и поток делится на две группы - удовлетворяющие предикату и нет
        //      Grouping - передаем две функции для создания ключей и значений - на выходе Map
        //      Reducing - вычисление какого-то значения по всем элементам потока
        //      Collection - создание коллекции на базе потока
        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobisheva", 19),
                new Student("Max", "Palov", 24)
        );

        System.out.println(
                students.stream().filter(s -> s.getLastName().toLowerCase().contains("s"))
                        .collect(Collectors.toList()) // ArrayList
        );

        Collection<String> c =
                students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                        .map(Student::getLastName)
                        .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(c);

        // List
        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toUnmodifiableList()); // RO List

        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toSet()); //


        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toUnmodifiableList()); // RO List

        // Set
        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toSet()); // Set

        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toCollection(TreeSet::new)); // TreeSet

        // Map
        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                //.map(Student::getLastName)
                .collect(Collectors.groupingBy(Student::getAge)); // Map<String, List<Student>>

        // формирует ключи
        Map<String, Student> stringStudentMap =
                students.stream() // Map<String, Student>
                        .collect(Collectors.toMap(
                                s -> s.getLastName() + " " + s.getFirstName(), // возвращает ключ в Map
                                Function.identity() // возвращает значение в Map
                                //s -> s
//                                new Function<Student, Student>() {
//                                    @Override
//                                    public Student apply(Student student) {
//                                        return student;
//                                    }
//                                }
                        ));
        System.out.println(stringStudentMap);

        // Collectors.toUnmodifiableMap() // RO Map

        // String
        System.out.println(
                students.stream()
                        .map(Student::getLastName)
                        .collect(Collectors.joining(", ", "<", ">"))
        );

        // Числовая статистика
        IntSummaryStatistics intSummaryStatistics =
                students.stream()
                        .collect(Collectors.summarizingInt(Student::getAge));

        // DoubleSummaryStatistics
        // LongSummaryStatistics

        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());


        students.stream()
                // filter ?
                .collect(Collectors.counting()); // количество элементов в потоке


        students.stream()
                // filter ?
                .collect(Collectors.summarizingInt(Student::getAge)); // сумма возрастов элементов в потоке

        Optional<Student> maxStudent =
                students.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparing(Student::getLastName)
                        ));

        // Collectors.minBy

        // Partition
        Map<Boolean, List<Student>> studentPartition =
                students.stream()
                        .collect(
                                Collectors.partitioningBy(s -> s.getLastName().endsWith("a"))
                        );

        System.out.println(studentPartition);
        // для studentPartition посчитайте сумму возрастов мужчин и женщин

        studentPartition.values().stream().map(
                list -> list.stream().map(Student::getAge).reduce(0, Integer::sum)
        ).forEach(System.out::println);

        int fAge = 0;
        int mAge = 0;
        for(Student s: students)
        {
            if(s.getLastName().endsWith("a"))
                fAge+= s.getAge();
            else
                mAge+= s.getAge();
        }
        System.out.println(fAge);
        System.out.println(mAge);

        studentPartition.values().stream()
                .map(
                        studentList -> studentList.stream()
                                .collect(Collectors.summarizingInt(Student::getAge))
                                .getSum()
                ).forEach(System.out::println);

        // groupingBy
        Map<Integer, List<Student>> studentsByAge =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge));

        System.out.println(studentsByAge);

        Map<Integer, Set<Student>> studentsByAgeSet =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));

        // studentsByAge
        // распечатайте возраст и количество студентов в каждом возрасте
        // studentsByAge.entrySet().stream()
        studentsByAge.forEach(
                (age, students1) -> System.out.println(age + ":" + students1.size())
        );

        // Custom Collector
        // interface Collector<T, A, R>
        // T - тип того что коллектор обрабатывает, например, Student
        // A - тип аккумулятора - коллекция куда студенты записываются либо для возвращения либо для
        // дальнейшей обработки
        // R - тип возвращаемого значения - например, коллекция List<Student> либо какая-то статистика -
        // Double если нужно посчитать средний возраст

        // supplier() должен возвратить Supplier который создаст тип возвращаемого значения (коллекцию) в которую потом
        // accumulator будет добавлять значения из потока
        // accumulator() - в него передается коллекция (Map) и один элемент из потока (Student)
        // accumulator определяет стратегию как именно конкретный Student будет добавляться в Map
        // combiner() - при параллельном выполнении потока отвечает за слияние промежуточных результатов Map
        // finisher() - преобразует коллекцию-аккумулятор в тип возвращаемого значения
        // characteristics()


        Map<Integer, List<Student>> customStudentsByAge =
                students.stream()//.parallel()
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {
                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                // создаем Map в которой будут накапливаться студенты
                                return HashMap::new;
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return (map, student) -> {
                                    // получить из student ключ
                                    int age = student.getAge();
                                    // посмотреть, есть ли в map список студентов с таким возрастом
                                    // если его нет, то создать этот список
                                    List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                    // добавить в список студента
                                    studs.add(student);
                                    // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                    map.put(age, studs);
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return (f, s) -> {
                                    f.putAll(s);
                                    return f;
                                };
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>> finisher() {
                                return map -> map;
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                            }
                        });

        System.out.println(customStudentsByAge);

        // Коллектор который вернет максимальное количество людей в одном возрасте
        int maxNumberOfStudentsInAge =
                students.stream()           // T входное  A аккумулятор             R выходное
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Integer>() {
                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                return HashMap::new;
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return (map, student) -> {
                                    // получить из student ключ
                                    int age = student.getAge();
                                    // посмотреть, есть ли в map список студентов с таким возрастом
                                    // если его нет, то создать этот список
                                    List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                    // добавить в список студента
                                    studs.add(student);
                                    // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                    map.put(age, studs);
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return (f, s) -> {
                                    f.putAll(s);
                                    return f;
                                };
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Integer> finisher() {
                                return map -> map.values().stream()
                                        .map(Collection::size)
                                        .max(Comparator.naturalOrder())
                                        .orElse(0);
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED);
                            }
                        });

        System.out.println(maxNumberOfStudentsInAge);

    }
}

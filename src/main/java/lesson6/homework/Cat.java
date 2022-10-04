package lesson6.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cat {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(
                Arrays.asList(
                        new Cat(Breed.BURMESE, 12, "Max"),
                        new Cat(Breed.BURMESE, 14, "Alex"),
                        new Cat(Breed.SIAMESE, 8, "Tihon")

                )
        );
        // отсортировать котов по возрасту
        cats.sort((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(cats); // коты по возрасту
        // отсортируйте котов по убыванию имен
        cats.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(cats); // коты по убыванию имен

        // отсортируйте котов по породе, потом по возрасту, потом по имени

       /* cats.sort((Comparator
                .comparing(Cat::getBreed)
                .thenComparing(Cat::getAge)
                .thenComparing(Cat::getName));*/

        System.out.println("Cats " + cats);

        cats.sort(
                Comparator
                        .comparing(Cat::getBreed)
                        .thenComparing(Cat::getAge)
                        .thenComparing(Cat::getName)
        );
        System.out.println(cats);

    }

    @Override
    public String toString() {
        return "Cat{" +
                "b=" + breed +
                ", a=" + age +
                ", n='" + name + '\'' +
                '}';
    }

    public enum Breed {
        BURMESE, SIAMESE,  SIBERIAN, SPHINX
        //0      1         2         3
    }
    private Breed breed;
    private int age;
    private String name;

    public Cat(Breed breed, int age, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

package lesson10.homework.lesson.setTeater;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTester {
    public static void main(String[] args) {
        // если мы планируем хэшированные контейнеры
        // нужно использовать в нашем классе equals() и hashCode()
        // у Object.hashCode() есть контракт
        // 1) На протяжении жизни объекта hashCode() должен выдавать один и тот же int
        // 2) Если o1.equals(o2) то o1.hashCode() == o2.hashCode() одинаковые хэшкоды

        // то что o1.hashCode() == o2.hashCode() НЕ означает что они эквивалентны

        // Vasya -> 228
        // Vasya -> 228

        // Petya -> 10
        // Masha -> 10


        // У класса, экземпляры которого сохраняются в хэш контейнерах
        // должны быть определены hashCode() и equals()
        Set<Point> points = new HashSet<>();
        points.add(new Point(10,20));
        points.add(new Point(10,20));

        System.out.println(points);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Set<Point> newPoint = new HashSet<>(); // обьекты не должны менятся в процессе хранения в хэшированном контейнере!!!!!!!!!!!!!!!!!!!
        Point p = new Point(10,20);
        newPoint.add(p);
        p.setX(1000);
        p.setY(1000);
        newPoint.add(p);
        System.out.println(newPoint);


        points.add(new Point(2,2));
        points.add(new Point(200,200));
        System.out.println(points);

        System.out.println(points.contains(new Point( 200, 200)));

        Set<Point> linkesPoints = new LinkedHashSet<>();
        linkesPoints.add(new Point(10,20));
        linkesPoints.add(new Point(2,2));
        linkesPoints.add(new Point(200,200));
        System.out.println(linkesPoints); // в LinkedHashSet гарантируется возвращние объектов в порядке вставки

        // TreeSet объекты возвтращаются в порядке сортировки
        // определенным для класса либо через Comparable либо через Comparator
        Set<Point> treePoints = new TreeSet<>();
        treePoints.add(new Point(10,20));
        treePoints.add(new Point(2,2));
        treePoints.add(new Point(200,200));
        System.out.println(treePoints);


    }
}

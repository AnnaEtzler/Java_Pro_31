package lesson8.homework7;

import java.util.*;

public class ArrayApp {
    public static void main(String[] args) {



        HomeworkList l = new HomeworkList();

        l.add(1);
        l.add(1);
        l.add(12);
        l.add(13);
        Iterator<Integer> myIterator = l.iterator();
        l.print();
        myIterator.hasNext();
        myIterator.hasNext();
        myIterator.remove();
        l.print();






    }
}

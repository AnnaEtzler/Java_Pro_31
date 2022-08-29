package lesson8.homework7;

import java.util.*;

public class ArrayApp {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();


        MyCustomArrayList l = new MyCustomArrayList();
        int [] a = new int[] {11,12,13,14};
        l.append(a);
        Iterator<Integer> myIterator = l.iterator();
        l.print();
        int k = 0;
        while (myIterator.hasNext()) {
            k = myIterator.next();
            if (l.get(k) == 14) {
                myIterator.remove();

                break;

            }
        }
        l.print();

        myIterator.remove();

        for (int i: l) {
            System.out.println("myList " + l.get(i));
        }



    }
}

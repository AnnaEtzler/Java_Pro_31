package lesson7.homework;

import java.util.Iterator;

public class Iterators {

    public static void main(String[] args) {
        MyList list = new MyListSimpleImplementation();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        for (int i = 0; i < list.size() ; i++) {
            System.out.println("list: " + list.get(i));
        }

        Iterator<Integer> myIterator = list.iterator();
        while (myIterator.hasNext()){
            System.out.println("iteratot next : " + myIterator.next());
        }

        for (int i: list) {
            System.out.println("myList " + i);

        }
    }


}

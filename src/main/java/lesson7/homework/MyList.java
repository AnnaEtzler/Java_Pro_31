package lesson7.homework;

import java.util.Iterator;

public interface MyList extends  Iterable<Integer> {
    void add(int value);
    void add(int index, int value);
    boolean contains(int value);
    int get(int index);
    void delete(int value);

    default void remove(int index){};

    int size();
    void set(int index, int value);

    void addFirst(int value);
    void removeFirst();
    int getFirst();

    Iterator<Integer> iterator();
}
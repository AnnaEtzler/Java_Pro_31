package lesson7.homework;

import java.util.Iterator;

public interface MyList extends  Iterable<Integer> {
    void add(int value);
    void set(int index, int value);
    void add(int index, int value);
    boolean contains(int value);
    int get(int index);
    void remove(int index);
    int size();
    Iterator<Integer> iterator();
}
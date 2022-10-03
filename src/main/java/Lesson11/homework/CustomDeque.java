package Lesson11.homework;


// Deque - Double Ended Queue вучторонняя очередь
// обеспечивает добавление и получение элементов с обоих концов контейнера
public interface CustomDeque {
    void addFirst(int i);

    int getFirst();

    int removeFirst();

    void addLast(int i);

    int getLast();

    int removeLast();

    int size();

}


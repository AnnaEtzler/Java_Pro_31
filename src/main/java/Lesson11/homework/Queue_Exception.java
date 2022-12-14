package Lesson11.homework;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_Exception {
// Queue - очередь - позволяет либо добавить элемент с конца очереди, либо забрать его из начала
// First-in First-out FIFO
// добавление
// boolean add(String s)  выбрасывает IllegalStateException если не тместа в очереди
// boolean offer(String s)  возвращает true если элемент вставили

// получение элемента
// String remove() возвращает первый элемент и убирает его из очереди
// если очередь пуста выбрасывает исклюение NoSuchElementException
// String poll() если очередь пуста возвращает null иначе возвращает и удаляет первый элемент

// возврат элемента
// String element() возвращает первый элемент и если очередь пуста выбрасывает исклюение NoSuchElementException
//  String peek() если очередь пуста возвращает null иначе возвращает первый элемент
public static void main(String[] args) {

    Queue<String> queue = new LinkedList<>();
    queue.add("Ann");
    queue.add("Max");
    queue.add("Bob");

    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());

    System.out.println(queue.poll());

    Queue<String> pqueue = new PriorityQueue();// по умолчанию приоритет это порядок сортировки типа (для String - это по возрастанию строк)
    pqueue.add("oneyyy"); //?? по алфавиту?
    pqueue.add("two");
    pqueue.add("treyyyyyyyyyye");
    pqueue.add("miau");

    System.out.println(pqueue.remove());
    System.out.println(pqueue.remove());
    System.out.println(pqueue.remove());
    System.out.println(pqueue.remove());

    try {
        hello();
    } catch (NoSuchElementException | IllegalArgumentException e){
        System.out.println("Go an exception " + e.getClass() + " " + e.getMessage());
    } catch (Exception e){
        System.out.println("miau");

    }
    System.out.println("weiter");
}
 public static  void hello() throws NoSuchElementException{
     Queue<String> queue = new LinkedList<>();
     queue.add("Ann");
     queue.add("Max");
     queue.add("Bob");

     System.out.println(queue.remove());
     System.out.println(queue.remove());
     System.out.println(queue.remove());

     throw new IllegalArgumentException("exept text");

 }

}

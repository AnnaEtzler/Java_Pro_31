package Lesson11.homework;

import java.util.*;
import java.util.List;

public class TestStack {
    // Stack добавляем элемент с одной стороны и получаем его с той же стороны
    // LIFO Last-in Last-out

    // T push(T element) добавляем элемент в вверх в стек
    // T pop() удаляет и возыращает самый верхний элемент стека
    // T peek() возвращает верхний элемент стека не удаляя его
    // boolean empty()

    public static void main(String[] args) {

        Stack<String> names = new Stack<>();

        names.push("gogo");
        names.push("mimi");
        names.push("uouo");

        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
        List list = new ArrayList(List.of("1", "2", "3"));

        System.out.println(reverse(list).toString());

        Integer[] array = new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        List<Integer> l = Arrays.asList(array);
        Queue<Integer> q = new LinkedList<>(Arrays.asList(array));

        System.out.println(reverse2(5, l));
        System.out.println(reverse3(5,q));

        CustomArrayDeque customArrayDeque = new CustomArrayDeque();
        customArrayDeque.addFirst(1);
        customArrayDeque.addFirst(2);


        System.out.println(customArrayDeque.getFirst());
        System.out.println(customArrayDeque.getLast());
        System.out.println(customArrayDeque.toString());


    }

    private static Queue<Integer> reverse2(int value, List list) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>(); // First-in First-out FIFO
        for (int i = value-1; i >= 0; i--) {
                queue.add((Integer) list.get(i));
        }
        for (int i = value; i < list.size(); i++){
            queue.add((Integer) list.get(i));
        }
        return queue;

    }
    private static Queue<Integer> reverse3(int number, Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number; i++){
            stack.add(queue.remove());
        }
        for (int i = 0; i < number; i++){
            queue.add(stack.pop());
        }
        for (int i = 0; i < queue.size() - number; i++){
            queue.add(queue.remove());
        }
        return  queue;


    }


    private static Collection<String> reverse(Collection<String> strings) {
        Stack<String> result = new Stack<>();
        result.addAll(strings);
        Collection<String> res = new ArrayList<>();
        while (!result.empty()) {
            res.add(result.pop());
        }
        return res;
    }

}

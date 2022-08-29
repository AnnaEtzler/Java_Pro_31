package lesson9;

import lesson7.homework.MyList;
import lesson8.homework7.MyCustomArrayList;

import java.util.Iterator;

public class MyLinkedList implements MyList {
    // Lists implementations. LinkedList.

    private Node head; // первый элемент списка
    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        Node n = head;
        b.append("[");
        while (n != null)
        {
            b.append(n.getValue());
            n = n.getNext();
            if(n != null)
            {
                b.append(",");
            }
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public void add(int value) {
        // идти начиная с head до последнего (пока getNext() != null)
        if(head == null)
        {
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null)
        {
            n = n.getNext();
        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new Node(value));
    }

    @Override
    public void add(int index, int value) {

    }

    public boolean contains(int value) {
        Node n = head;
        while (n != null)
        {
            if(n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int get(int index) {
        Node n = head;
        while (n != null)
        {
            if(index == 0)
                return n.getValue();
            index--;
            n = n.getNext();
        }
        return 0;
    }

    @Override
    public void delete(int value) {
        Node nodePrev = head;
        Node node = head.getNext();
        if(nodePrev.getValue() == value){
            this.removeFirst();
            return;
        }

        while (node != null)
        {
            if(node.getValue() == value ){
                nodePrev.setNext(node.getNext());
                return;

            }
            nodePrev = node;
            node = nodePrev.getNext();

        }

    }



    @Override
    public int size() {
        int sz = 0; // size
        Node n = head;
        while (n != null)
        {
            sz++;
            n = n.getNext();
        }
        return sz;
    }

    @Override
    public void set(int index, int value) {
        Node n = head;
        while (n != null)
        {
            if(index == 0) {
                n.setValue(value);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public void addFirst(int value) {

        Node nNew = new Node(value);
        nNew.setNext(head);
        head = nNew;


    }

    @Override
    public void removeFirst() {
        head = head.getNext();

    }

    @Override
    public int getFirst() {
        return head.getValue();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return 0;
            }

            @Override
            public void remove() {

            }
        };
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        // Node n = new MyLinkedList().new Node(); // внутренний не статический класс
        // Node n = new MyLinkedList.Node(); // внутренний статический класс
        MyLinkedList l = new MyLinkedList();
        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        System.out.println(l.size());
        System.out.println(l.get(2));
        l.set(0,10);
        System.out.println(l +"======================");
        l.addFirst(44);
        l.addFirst(33);
        System.out.println(l);
        l.removeFirst();
        l.removeFirst();
        System.out.println(l);
        System.out.println(l.getFirst());
        l.delete(2);
        System.out.println(l);
        Iterator<Integer> iterator = new MyLinkedList().iterator();
        iterator.next();
        iterator.remove();
        System.out.println(l);


    }
}
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
    public void remove(int index) {

    }


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


    public void addFirst(int value) {

        Node nNew = new Node(value);
        nNew.setNext(head);
        head = nNew;


    }


    public void removeFirst() {
        head = head.getNext();

    }


    public int getFirst() {
        return head.getValue();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int position = 0;


            @Override
            public boolean hasNext() {
                return position++ < size()-1 ;
            }

            @Override
            public Integer next() {

                return  get(position);
            }

            @Override
            public void remove() {
                MyLinkedList.this.delete(get(position));

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
        l.add(4);
        l.delete(3);
        System.out.println(l);
        System.out.println(l.size());
        System.out.println(l.get(2));
        l.set(0,10);
        System.out.println(l +"======================");
        l.addFirst(44);
        l.addFirst(33);
        System.out.println(l);
        System.out.println("____________");
        Iterator<Integer> iterator2 = l.iterator();
        System.out.println(iterator2.hasNext());
        System.out.println(iterator2.next());
        iterator2.remove();
        System.out.println(l);




    }
}
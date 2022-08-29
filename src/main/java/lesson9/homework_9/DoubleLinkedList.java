package lesson9.homework_9;

import lesson9.MyLinkedList;

public class DoubleLinkedList {
    private Node head;
    private Node tail;


    public void addLast(int value){
        if(head == null)
        {
            head = new Node(value);
            tail = head;
            return;
        }

        Node n = tail;
        Node nNew = new Node(value);
        nNew.setPrev(n);
        n.setNext(nNew);
        tail = nNew;
    }
    public void addFirst(int value){
        Node nNew = new Node(value);
        nNew.setNext(head);
        head = nNew;
    }

    public void removeLast(){
        tail = tail.getPrev();
        tail.setNext(null);
    }

    public void remove(int value){
        Node nodePrev = head;
        Node node = head.getNext();
        if(nodePrev.getValue() == value){
            this.removeFirst();
            return;
        }
        if(tail.getValue() == value){
            this.removeLast();
            return;
        }

        while (node != null)
        {
            if(node.getValue() == value ){
                nodePrev.setNext(node.getNext());
                node.getNext().setPrev(nodePrev);
                return;

            }
            nodePrev = node;
            node = nodePrev.getNext();

        }
    }

    private void removeFirst() {
        head = head.getNext();
        head.setPrev(null);
    }



    public int getLast(){
        return tail.getValue();
    }

    public int getFirst(){
        return head.getValue();
    }


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

    public void set(int index, int value){
        Node n = head;
        while (n != null){
            if(index == 0){
                n.setValue(value);
            }
            index--;
            n = n.getNext();

        }

    }

}

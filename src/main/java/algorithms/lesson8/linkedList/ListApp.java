package algorithms.lesson8.linkedList;

public class ListApp {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.pushToHead(1);
        myLinkedList.pushToHead(2);
        myLinkedList.pushToHead(3);
        myLinkedList.pushToIndex(0,555);
        myLinkedList.remove(4);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));




    }




}

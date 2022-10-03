package algorithms.linkedList;

public class ListApp {
    public static void main(String[] args) {

        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node = new Node(1,node2);

        ListApp listApp = new ListApp();



        MyLinkedList myLinkedList = new MyLinkedList();

    }




}

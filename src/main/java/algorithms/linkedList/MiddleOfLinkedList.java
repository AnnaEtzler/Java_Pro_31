package algorithms.linkedList;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node node6 = new Node(5, null);
        Node node5 = new Node(1,node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(777, node4);
        Node node2 = new Node(2, node3);
        Node node = new Node(1,node2);

        Node head = new Node(1,node2);
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        System.out.println(middleOfLinkedList.getMiddleValue(head));

    }

    private int getMiddleValue(Node head) {
        if(head == null){
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }
}

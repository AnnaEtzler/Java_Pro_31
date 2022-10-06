package algorithms.lesson8.linkedList;

public class MyLinkedList {
    private Node head;
    private  int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    //O(1)
    public void pushToHead(int data){
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;



    }
    // O(1) it use additional variable with link to last element
    //O(n) Time complexity
    public  void pushToTail(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            size++;
            return;

        }
        Node curr = head;
        while (curr.getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(node);
    }

    public boolean removeFirst(){
        if(head == null){
            return false;
        }
        Node curr = head;
        head = curr.getNext();
        curr.setNext(null);
        size--;
        return true;
    }

    public boolean removeLast(){
        if(head == null){
            return false;
        }
        Node curr = head;
        Node prev = null;
        while (curr.getNext() != null){
            prev = curr;
            curr = curr.getNext();
        }
        if(prev != null){
            prev.setNext(null);
        }
        return true;
    }

    private void print(Node node){
        while (node != null){
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }

    }
    private int getNode(Node node, int number) {
        if(number == 0){

        }
        while ( node != null && number > 1){
            node = node.getNext();
            number--;
        }
        return node.getData();

    }

    public void pushToIndex(int index, int data){
        Node node = head;
        Node prev = null;
        while (node != null && index > 0) {
            index--;
            prev = node;
            node = node.getNext();
        }
        Node nodeNew = new Node(data);
        nodeNew.setNext(node);
        if(prev == null){
            head = nodeNew;
            return;
        }
        prev.setNext(nodeNew);

    }


    public void remove(int index){
        if(index >= size){
            System.out.println("index должен быть < size");
            return;
        }
        Node node = head;
        Node prev = null;
        while (node != null && index > 0) {
            index--;
            prev = node;
            node = node.getNext();
        }
        if(prev == null){
            head = node.getNext();
            return;
        }

        prev.setNext(node.getNext());



    }
    public int get(int index) {
        Node node = head;
        while (node != null && index > 0) {
            index--;
            node = node.getNext();
        }
        int result;
        try {
            result = node.getData();
        } catch (NullPointerException e) {
            System.out.print("Элемента не существует ");
            result=  -1;
        }
        return result;


    }
    public boolean isCycle(){
        Node node = head;
        int index = size;
        while (node != null && index > 0) {
            index--;
            node = node.getNext();
        }
        if(node.getNext() != null){
            return true;
        }
        return false;

    }
}

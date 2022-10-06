package algorithms.lesson8.linkedList;

//Second level: Задача:
//Написать метод, который будет проверять наличие цикла в связном спиcке.(возвращает true или false)
//Как понять это есть цикл ?
//Для данной задачи, цикл - когда последний элемент связного списка ссылается
//не на null, а на какой либо предыдущий элемент.
//Пример :
//Список без цикла : // 1 - 2 -3 - 4 - 5
//Список с циклом : // 1 - 2 -3 - 4 - 5 - 3
public class Node {
    private int data;
    private  Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}

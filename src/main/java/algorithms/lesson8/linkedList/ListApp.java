package algorithms.lesson8.linkedList;
////Second level: Задача:
////Написать метод, который будет проверять наличие цикла в связном спиcке.(возвращает true или false)
////Как понять это есть цикл ?
////Для данной задачи, цикл - когда последний элемент связного списка ссылается
////не на null, а на какой либо предыдущий элемент.
////Пример :
////Список без цикла : // 1 - 2 -3 - 4 - 5
////Список с циклом : // 1 - 2 -3 - 4 - 5 - 3
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
        System.out.println(myLinkedList.isCycle());




    }




}

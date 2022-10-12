package lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson20 {
    public static void main(String[] args) {
        // Java Streams: Flat map.

        // filter может пропустить от 0 до n элементов
        // map пропускает элементы 1->1
        // flatMap
        // map только трансформирует элемент
        // flatMap и трансформирует и "уплощать"
        // flattening = уплощение

        List<List<String>> list = Arrays.asList(
                Arrays.asList("Max", "Alex"),
                Arrays.asList("Xenia", "Maria", "Daria")
        );
        list.stream().forEach(
                System.out::println
        );

        list.stream().flatMap(l -> l.stream())
                .forEach(System.out::println);

        int[][] ints = {{1, 2, 3}, {4}};
        System.out.println(
                Arrays.toString(
                        Arrays.stream(ints).flatMapToInt(i -> Arrays.stream(i)).toArray())
        );

        Order grosery = new Order();
        Order utility = new Order();

        grosery.addItems(
                new OrderItem("mango", 5, 1.45),
                new OrderItem("apples", 2, 2.20),
                new OrderItem("Red Bull", 10, 1.3)
        );
        utility.addItems(
                new OrderItem("Diesel", 20, 2.20),
                new OrderItem("Water", 120, 0.97),
                new OrderItem("Electricity", 50, .89)
        );

        List<Order> orders = List.of(grosery, utility);
        double amount = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getUnitPrice()* item.getQuantity())
                .sum();

        System.out.println(amount);
    }
}

class Order{
    private List<OrderItem> items = new ArrayList<>();
    public void addItems(OrderItem ... items){  // varargs - от 0 до неограниченого коли-ва элементов
        // items выглядит как массив
        this.items.addAll(Arrays.asList(items));
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
class OrderItem{
    private String title;
    private int quantity;
    private  double unitPrice;

    public OrderItem(String title, int quantity, double unitPrice) {
        this.title = title;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
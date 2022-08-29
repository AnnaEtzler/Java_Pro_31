package lesson2.homeWork;

import java.util.ArrayList;
import java.util.List;

// Создайте класс PizzaOrder куда можно будет добавлять пиццу
// методом add(Pizza)
// и напишите в этом классе метод calcTotalPrice(): int который вычислит стоимость всех заказанных пицц.
public class PizzaOrder {
    private List<Pizza> pizzaOrder = new ArrayList<>();

    public void add(Pizza pizza){
        pizzaOrder.add(pizza);
    }

    public int calcTotalPrice(){
        int totalPrice = 0;
        for (Pizza p: pizzaOrder){
            totalPrice += p.calcPrice();
        }
        return totalPrice;
    }
}


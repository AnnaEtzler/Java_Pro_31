package lesson3;

import lesson4.Animals;
import lesson4.BigDog;

//Создайте перечисление Weekday дней недели - MONDAY, ..., SUNDAY. Напишите в этом перечислении функции
// isWeekDay():true - является ли день рабочим и функцию isWeekEnd(): true - является ли день выходным.
// Создате перечисление Cru. BASE(80), PREMIER(90), GRAND(100). Добавьте поле quality:int и добавьте конструктор.
public class Homework {

    public static void main(String[] args) {
        Animals dog = new BigDog("Kikiska");
        dog.greets();
    }


}



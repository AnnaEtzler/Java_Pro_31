package lesson5;

import com.google.gson.Gson;
import lesson4.lines.Point;

public class JsonTester {


        public static void main(String[] args) {
            // объект -> текст = сериализация serialization
            // текст -> объект = десериализация (парсинг)

            Point p  = new Point(33,44);

            Gson gson = new Gson();
            String s = gson.toJson(p);
            System.out.println(s);

            String stringPoint = "{'x':10, 'y':20}";

            Point point = gson.fromJson(stringPoint, Point.class);
            System.out.println(point.getX() + " " + point.getY());

        }

}

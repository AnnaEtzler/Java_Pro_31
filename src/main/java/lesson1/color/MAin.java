package lesson1.color;
import java.io.Console;
import java.util.*;

import com.google.gson.JsonObject;
import lesson4.lines.Point;
import lesson4.lines.PolyLine;
import lesson4.lines.Rectangle;

public class MAin {


    public static void main(String[] args) {



        Color c = new Color(33,5,66);
        System.out.println(c.RGBtoHSL());

        Integer a = 130;
        Integer b = 130;
        System.out.println(a==b);
        System.out.println(a.equals(b));


    }
}

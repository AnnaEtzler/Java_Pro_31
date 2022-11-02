package Lesson26;

import java.io.IOException;
import java.util.Random;

public class Lesson26 {
    public static void main(String[] args) throws IOException {
        String name = "Max";
        System.out.println(((Object) name).hashCode());
        String newName = name;

        System.out.println(newName == name);

        name += " Kotkov";
        System.out.println(newName == name);

        StringBuilder builder = new StringBuilder("MAx");
        System.out.print("StringBuilder ");
        check(builder);// 2098




        StringBuffer buffer = new StringBuffer("Max"); // для многопоточной среды
        System.out.print("StringBuffer ");
        check(buffer); //1933
    }

    public static void check(Appendable builder) throws IOException {
        Random random = new Random();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++){
            builder.append("" + random.nextDouble());
        }
        long after = System.currentTimeMillis();
        System.out.println("time " + (after - before));

    }
}

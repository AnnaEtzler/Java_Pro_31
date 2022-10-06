package lesson13;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetTester {
    public static void main(String[] args) {
        TreeSet<String> groups = new TreeSet<>(Arrays.asList(
                "Abba",
                "Boney M",
                "Led Zeppelin",
                "Aerosmith",
                "Pearl Jam",
                "ZZ Top"
        ));

        System.out.println(groups);

        System.out.println(groups.subSet("CC Catch", "Sandra"));

        System.out.println(groups.tailSet("Fridays"));
    }
}

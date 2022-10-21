package lesson23;

import java.io.BufferedReader;
import java.io.StringReader;

public class StringStreamTester {
    public static void main(String[] args) {
        String hello = "hello\nworld\nhoe are you?";
        StringReader stringReader = new StringReader(hello);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        bufferedReader.lines().forEach(System.out::println);
    }
}

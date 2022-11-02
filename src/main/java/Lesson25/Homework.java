package Lesson25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Homework {
    public static void main(String[] args) {
        System.out.println(getLongestWord("src/main/resources/test.txt"));

    }

    public static String getLongestWord(String filename){
        String result = "";
        try(FileReader fileReader = new FileReader(filename); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            result = bufferedReader.lines()
                    .flatMap(linie -> Arrays.stream(linie.split("\\s+")))
                    .max(Comparator.comparing(String::length)).orElse("");



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  result;

    }
}

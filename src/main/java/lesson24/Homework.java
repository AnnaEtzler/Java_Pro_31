package lesson24;

//
//
//*** Переделайте четвертое задание (с машинами) на stream-ы (до 1.11)
//
//
//** Напишите функцию-аналог dir или ls -l - должна принимать на вход путь к директории.
//В выводе должны присутствовать типы файлов (d для директории и - для обычного файла),
// размер файла и название. Также добавьте правильный формат строк (printf(…)) (до 1.11)

import java.io.*;
import java.util.*;

public class Homework {
    public static void main(String[] args) {
        //Найдите самое длинное слово в текстовом файле (до 27.10)
        String result = "";
        try (FileReader fr = new FileReader("src/main/resources/test.txt"); BufferedReader br = new BufferedReader(fr)) {
            List<String> s = new ArrayList<>();
            br.lines().forEach(x -> Arrays.stream(x.split(" ")).forEach(y -> s.add(y)));
            result = String.valueOf(s.stream().max(Comparator.comparingInt(String::length)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);

    }
}

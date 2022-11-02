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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;

import static java.lang.System.out;

public class Homework {
    public static void main(String[] args) throws IOException {
        task2("D:\\TelRan");
        dir("D:\\TelRan");

       // longWort();//Найдите самое длинное слово в текстовом файле (до 27.10)



    }

    private static void longWort() {
        Optional result = null;
        try (FileReader fr = new FileReader("src/main/resources/test.txt"); BufferedReader br = new BufferedReader(fr)) {
            List<String> s = new ArrayList<>();
            br.lines().forEach(x -> Arrays.stream(x.split(" ")).forEach(y -> s.add(y)));
            result = s.stream().max(Comparator.comparingInt(String::length));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println(result.get());

    }

    //** Напишите функцию-аналог dir или ls -l - должна принимать на вход путь к директории.
    //В выводе должны присутствовать типы файлов (d для директории и - для обычного файла),
    // размер файла и название. Также добавьте правильный формат строк (printf(…)) (до 1.11)
    private static void task2(String path){
        File file  = new File(path);
        File [] fileList = file.listFiles();

        StringBuilder sb = new StringBuilder();
        Arrays.stream(fileList).forEach( f ->
            sb.append(f.isDirectory() ? "d " : "  ").append(f.length()).append(" ").append(f.getName()).append("\n")
        );

        out.println(sb);

    }
    private static void dir(String d) throws IOException {
        File dir = new File(d);
        String dirAbsPath = dir.getAbsolutePath(); // полный путь к директории
        String sep = File.separator;
        String [] files = dir.list();
        for(int i = 0; i < files.length; i++)
        {
            String name = files[i];
            Path path = Path.of(dirAbsPath + sep + name);
            UserPrincipal user = Files.getOwner(path);
            out.print(
                    Files.isDirectory(path) ? "d" : "-"
            );
            out.print(
                    Files.isReadable(path) ? "r" : "-"
            );
            out.print(
                    Files.isWritable(path) ? "w" : "-"
            );
            out.print(
                    Files.isExecutable(path) ? "x" : "-"
            );
            out.printf(" %15s %10d %30s\n", user.getName(), Files.size(path), name);
        }
    }
}

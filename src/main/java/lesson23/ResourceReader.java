package lesson23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class ResourceReader {
    public static void main(String[] args) throws IOException {
      //  FileReader fileReader = new FileReader("src/main/resources/test.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/test.txt"));
        int res = lines.stream()
                        .map(Integer::parseInt)
                                .reduce(0, Integer::sum);

        System.out.println("result " + res);


        Scanner scanner = new Scanner(new FileInputStream("src/main/resources/test.txt"));
        int result = 0;
        while (scanner.hasNext()){
            result += scanner.nextInt();
        }
        System.out.println("result " + result);

    }
}

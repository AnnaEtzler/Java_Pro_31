package lesson22;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderWriterTester {
    public static void main(String[] args) {
       /* String line = "";
        List<String> lines = new ArrayList<>();
        System.out.println("Enter lines until stop");
        Scanner keyboard = new Scanner(System.in);
        do {
            line = keyboard.nextLine();
            lines.add(line);
        }while (!line.equals("stop"));
        try (FileWriter fileWriter = new FileWriter("lines.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        )
        {
            for(int i = 0; i < lines.size(); i++)
            {
                bufferedWriter.write(lines.get(i));
            }
        }catch (IOException e)
        {
            System.err.println("Exception: " + e.getMessage());
        }*/

        try(FileReader fileReader = new FileReader("lines.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            bufferedReader.lines().forEach(
                    System.out::println
            );
        }
        catch (IOException e)
        {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

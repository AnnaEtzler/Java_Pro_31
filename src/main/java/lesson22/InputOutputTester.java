package lesson22;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputTester {
    public static void main(String[] args) throws IOException {
        byte [] data = new byte[10];
        System.out.println("Please enter some characters");
        int number = System.in.read(data);
        System.out.println("You entered " + number);
        for (int i = 0; i < data.length; i++){
            System.out.print((char) data[i]);
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream("result.txt"))
        {
            for (int i = 0; i < data.length; i++){
                fileOutputStream.write(data[i]);
            }

        }
    }
}

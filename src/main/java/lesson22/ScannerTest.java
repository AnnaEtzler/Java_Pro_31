package lesson22;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enteted your age: ");
        int age = 0;
        double salary = 0;
        if (keyboard.hasNext()) {
            age = keyboard.nextInt();
        }
        System.out.println("Enter your salary: ");
        if (keyboard.hasNextDouble()) {
            salary = keyboard.nextDouble();
        }
        System.out.println("you age: " + age + " you salary " + salary);

        System.out.println("Enter your name: ");
        String name = "";
        keyboard.nextLine();
        if (keyboard.hasNext())
            name = keyboard.nextLine();
        System.out.println("Your name is: " + name);
    }

}

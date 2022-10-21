package lesson23;

import java.io.*;
import java.util.StringTokenizer;

public class EmployeeTester {
    public static void main(String[] args) {
       /* Employee e = new Employee("Max Kotikov", 15000, 23);
        try (
                PrintWriter printWriter = new PrintWriter("employee.txt");
        )
        {
            printWriter.println(
                    e.getName() + "|" + e.getSalary() + "|" + e.getAge()
            );
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }


        */

        try( BufferedReader bufferedReader = new BufferedReader(new FileReader("employee.txt"))){

            String s = bufferedReader.readLine();
            StringTokenizer t = new StringTokenizer(s, "|");
            String name = t.nextToken();
            double salary = Double.parseDouble(t.nextToken());
            int age = Integer.parseInt(t.nextToken());
            Employee e = new Employee(name, salary,age);
            System.out.println(e);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

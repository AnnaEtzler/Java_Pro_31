package lesson22;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.logging.Logger;

//Напишите функции которые сериализуют и десериализуют экземпляр какого-нибудь класса в json-представление в текстовом файле и обратно
//Можно воспользоваться библиотекой Gson
public class Homework {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 3, "brown");
        Cat c = getEmployeeFromFile("catJSON.json", Cat.class);
        System.out.println(c);
       /* GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String s = gson.toJson(cat);
        System.out.println(s);

        File output = new File("catJSON.json");
        try (FileWriter writer = new FileWriter(output)) {
            writer.write(s);
            writer.flush();
            System.out.println("Записано в файл  catJSON.json");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Чтение из файла catJSON.json");
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader("catJSON.json"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {


            while (fileReader.ready()) {
                sb.append((char) fileReader.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Cat catFromJSON = gson.fromJson(sb.toString(), Cat.class);
        System.out.println(catFromJSON.toString());*/


    }

    public static <T>  T getEmployeeFromFile(String filename, Class<T> clazz)
    {
        Gson gson = new Gson();
        Cat employee = null;
        try(
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            employee = gson.fromJson(bufferedReader, Cat.class);
        }
        catch (Exception e)
        {
            System.err.println("exception: " + e.getMessage());
        }
        return (T) employee;
    }

    public static Cat getEmployeeFromFile2(String filename)
    {
        Gson gson = new Gson();
        try(
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            StringBuilder b = new StringBuilder();
            bufferedReader.lines().forEach(
                    line -> b.append(line)
            );
        }
        catch (Exception e)
        {
            System.err.println("exception: " + e.getMessage());
        }
        return null;
    }
}


class Cat {
    public String name;
    public int age;
    public String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
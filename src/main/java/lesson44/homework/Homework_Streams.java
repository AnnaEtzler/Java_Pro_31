package lesson44.homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//� ������� Stream-�� ������������ ������ �����, ���������� ������ �� �� ���, ������� �������� ������������ -
// �.�., ��������� �������� ��� ������ ������ � ����� - ��������, "���
public class Homework_Streams {
    public static void main(String[] args) {
//� ������� Stream-�� ���������� ����� �������� ��������� ������� ����� - �������������� IntStream.range(0, ...)
// ��� ��������� ������������������ ������� ��������� - ���������, ��� ���������� �� � �������� �����
        int result = IntStream.range(0, 10).filter(value -> value % 2 != 0).sum();
        System.out.println(result); //1 3 5 7 9 = 25


//� ������� Stream-�� ������������ ������ �����, ������� �� �� ���������� �� ������� ������� �� ���������.
// �.�., ��� �������� "Max" ��������� ��� ��������� ������ ���� "ax".
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(List.of("Anna", "Max", "Bob")); // ax nna ob

        arrayList.sort(Comparator.comparing(o -> (o.substring(1, o.length()))));
        System.out.println(arrayList);

        //� ������� Stream-�� ������������ ������ �����, ���������� ������ �� �� ���, ������� �������� ������������ -
        // �.�., ��������� �������� ��� ������ ������ � ����� - ��������, "���

        ArrayList <String> a = new ArrayList(List.of("ABBA", "baba", "odddo", "qwerty"));
        a.stream().
                filter(s -> {return new StringBuilder(s).reverse().toString().equals(s);})
                .forEach(System.out::println);
    }

}

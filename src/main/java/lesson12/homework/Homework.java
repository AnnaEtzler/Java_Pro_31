package lesson12.homework;

import java.util.Stack;

//ДЗ проф ява
//Дописать CustomArrayDeque
//*** Написать тесты
//*** Написать toString()
//****** Написать функцию, которая проверяет сбалансированность скобок трех видов.
// Пример "{}()" -> true, "{()[]}" -> true, "[}" -> false, "{{{])" -> false
// Подумайте, какие из пройденных контейнеров можно использовать - Stack, Queue, Deque
public class Homework {
    public static void main(String[] args) {
        System.out.println(checkParentheses("{}()")); // t
        System.out.println(checkParentheses("{()[]}")); // t
        System.out.println(checkParentheses("[}")); // f
        System.out.println(checkParentheses("{{{])")); // f
        System.out.println(checkParentheses("{()()[[()]()]}")); // t
    }

    // Написать функцию, которая проверяет сбалансированность скобок трех видов.
    // Пример "{}()" -> true, "{()[]}" -> true, "[}" -> false, "{{{])" -> false
    // Подумайте, какие из пройденных контейнеров можно использовать - Stack, Queue, Deque
    public static boolean checkParentheses(String s)
    {
        Stack<Character> chars = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
                chars.push(c);
            else if (
                    c == ')' && chars.peek() == '(' ||  // проверка без удаления
                            c == ']' && chars.peek() == '[' ||
                            c == '}' && chars.peek() == '{'
            )
            {
                chars.pop();
            }
        }
        return chars.size() == 0;
    }
}


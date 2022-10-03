package lesson12.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
    public static void main(String[] args) {
        // алла
        // а роза упала на лапу азора
        System.out.println(checkPalindrome("алла")); // true
        System.out.println(checkPalindrome("ал")); // false
        System.out.println(checkPalindrome("а роза упала на лапу азора")); // true
        // "{..}[asdd]"
    }
    // написать проверку на палиндромность
    public static boolean checkPalindrome(String p)
    {
        Deque<Character> chars = new ArrayDeque<>();
        p = p.replaceAll(" ", "");
        for(Character c: p.toCharArray())
        {
            chars.add(c);
        }

        while (chars.size() > 1 ){
            if(!chars.removeFirst().equals(chars.removeLast()))
                return false;
        }
        return true;
    }
}
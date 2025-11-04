package com.example.palindrome;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        boolean isPalindrome = true;
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }
        s = normalize(s);
        for (char c : s.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (!queue.isEmpty() && isPalindrome) {
            isPalindrome = queue.remove().equals(stack.pop());
        }
        return isPalindrome;
    }

    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}

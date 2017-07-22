package Lab03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Pr07_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palindromeCandidate = scanner.nextLine();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : palindromeCandidate.toCharArray()){
            queue.offer(c);
        }

        boolean isPalindrome = true;
        while (queue.size() > 1) {
            char first = queue.poll();
            char last = queue.pollLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
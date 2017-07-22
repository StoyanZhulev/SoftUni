package Ex03_StacksAndQueues;

import java.util.Scanner;

public class Pr09_RecursiveFibunaci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = Integer.parseInt(console.next());

         System.out.println(recursiveFibonacci(n));
    }

    private static long recursiveFibonacci(long n) {
        if (n <= 1) {
            return 1;
        }

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
}

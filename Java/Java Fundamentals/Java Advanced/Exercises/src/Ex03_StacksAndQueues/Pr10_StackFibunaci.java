package Ex03_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Pr10_StackFibunaci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = Integer.parseInt(console.next());
        long firstNum = 1;
        long secondNum = 1;

        Stack<Long> fibStack = new Stack<>();

        fibStack.push(firstNum);
        fibStack.push(secondNum);

        for (int i = 1; i < n; i++)
        {

            long secondNumber = fibStack.pop();
            long number = fibStack.peek() + secondNumber;

            fibStack.push(secondNumber);
            fibStack.push(number);
        }

        System.out.println(fibStack.peek());

    }
}

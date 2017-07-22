package Lab03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Integer.parseInt(scanner.nextLine());

        if(number == 0){
            System.out.println("0");
            return;
        }
        ArrayDeque<Long> stack = new ArrayDeque<>();
        while(number != 0){
            stack.push(number % 2);
            number /= 2;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }


    }
}

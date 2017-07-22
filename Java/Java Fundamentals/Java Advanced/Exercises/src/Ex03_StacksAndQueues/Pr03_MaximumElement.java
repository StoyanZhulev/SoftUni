package Ex03_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Pr03_MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxNums = new Stack<>();

        int commandsCount = Integer.parseInt(console.nextLine());
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < commandsCount; i++) {
            int command = console.nextInt();

            if(command == 1){
                int numToPush = console.nextInt();
                stack.push(numToPush);
                if(numToPush >= max){
                    max = numToPush;
                    maxNums.push(max);
                }
            } else if(command == 2){
                int poppedNum = stack.pop();
                if (poppedNum == max) {
                    maxNums.pop();
                    max = maxNums.peek();
                }
            }else{
                System.out.println(max);
            }
        }
    }
}

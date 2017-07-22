package Ex03_StacksAndQueues;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Pr01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        String[] input = console.nextLine().split(" ");

        for (int i = 0; i <input.length ; i++) {
            stack.push(Integer.parseInt(input[i]));
        }

        Collections.reverse(stack);
        for (Integer num : stack){
            System.out.print(num + " ");
        }
    }


    /*
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for (int num : input) {
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
 */

}

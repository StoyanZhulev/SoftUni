package Lab03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr01_ReverseString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (Character chars : input.toCharArray()) {
            stack.push(chars);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}

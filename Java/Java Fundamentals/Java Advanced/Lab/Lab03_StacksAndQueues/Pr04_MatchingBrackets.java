package Lab03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char symbol = expression.charAt(index);
            if(symbol == '('){
                stack.push(index);
            }else if(symbol == ')'){
                String subExpr = expression.substring(stack.pop(), index + 1);
                System.out.println(subExpr);
            }
        }
    }
}

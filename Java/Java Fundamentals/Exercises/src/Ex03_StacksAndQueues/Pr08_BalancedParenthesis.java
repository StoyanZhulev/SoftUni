package Ex03_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Pr08_BalancedParenthesis {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        if (isBalanced(input)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if(symbol == '{' || symbol == '[' || symbol == '('){
                stack.push(symbol);
            }else if(symbol == '}'){
                if(stack.isEmpty()){
                    return false;
                } else if(stack.pop() != '{'){
                    return false;
                }
            }else if(symbol == ']'){
                if (stack.isEmpty()){
                    return false;
                }else if(stack.pop() != '['){
                    return false;
                }
            }else if( symbol == ')'){
                if(stack.isEmpty()){
                    return false;
                }else if (stack.pop() != '('){
                    return false;
                }
            }
        }
        return true;
    }
}

package Ex03_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Pr11_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String currentString = "";
        Stack<String> stack = new Stack<>();

        stack.push(currentString);
        for (int i = 0; i < n; i++) {
            String[] commandArgs = console.nextLine().split(" ");
            int command = Integer.parseInt(commandArgs[0]);

            if(command == 1){
                String textToAppend = commandArgs[1];
                currentString += textToAppend;
                stack.push(currentString);
            }else if(command == 2){
                int elementsToErase = Integer.parseInt(commandArgs[1]);
                currentString = currentString.substring(0, currentString.length() - elementsToErase);
                stack.push(currentString);
            }else if(command == 3){
                int index = Integer.parseInt(commandArgs[1]);
                System.out.println(currentString.charAt(index - 1));
            }else if(command == 4){
                stack.pop();
                currentString = stack.peek();
            }
        }
    }
}

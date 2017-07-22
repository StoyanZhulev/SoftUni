package Ex03_StacksAndQueues;


import java.util.Scanner;
import java.util.Stack;

public class Pr02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");

        int numbersCount = Integer.parseInt(input[0]);
        int numbersToPop = Integer.parseInt(input[1]);
        int numberSearched = Integer.parseInt(input[2]);

        String[] nums = console.nextLine().split(" ");
        Stack<Integer> numbers = new Stack<>();
        Stack<Integer> minNumbers = new Stack<>();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            numbers.push(Integer.parseInt(nums[i]));
            if(Integer.parseInt(nums[i]) < min){
                minNumbers.push(numbers.peek());
            }
        }

        for (int i = 0; i < numbersToPop; i++) {
            if(numbers.peek() == minNumbers.peek()){
                minNumbers.pop();
            }
            numbers.pop();

        }

        if(numbers.contains(numberSearched)){
            System.out.println("true");
        }else if(numbers.size() != 0) {
            System.out.println(minNumbers.peek());

        }else{
            System.out.println("0");
        }

    }
}

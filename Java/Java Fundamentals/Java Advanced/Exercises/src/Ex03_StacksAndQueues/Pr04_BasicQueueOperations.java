package Ex03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Pr04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");

        int numbersCount = Integer.parseInt(input[0]);
        int numberToPop = Integer.parseInt(input[1]);
        int numberSearched = Integer.parseInt(input[2]);

        String[] nums = console.nextLine().split(" ");
        Queue<Integer> numbers = new ArrayDeque<>();
        Queue<Integer> minNumber = new ArrayDeque<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            numbers.add(Integer.parseInt(nums[i]));
            if(Integer.parseInt(nums[i]) < min){
                if(minNumber.size() != 0){
                    minNumber.poll();
                }
                min = Integer.parseInt(nums[i]);
                minNumber.add(min);
            }
        }

        for (int i = 0; i < numberToPop; i++) {
            int numToPoll = numbers.poll();

            if(numToPoll == min){
                minNumber.poll();
                if(minNumber.isEmpty()){
                    min = Integer.MAX_VALUE;
                }else{
                    min = minNumber.peek();

                }
            }
        }

        if(numbers.contains(numberSearched)){
            System.out.println("true");
        } else {
            if(minNumber.isEmpty()){
                System.out.println("0");
            }else{
                System.out.println(min);

            }
        }
    }
}

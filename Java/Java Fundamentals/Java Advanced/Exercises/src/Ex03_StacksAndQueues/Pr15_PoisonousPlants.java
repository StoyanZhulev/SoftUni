package Ex03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Pr15_PoisonousPlants {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[] plants = console.nextLine().split(" ");

        int[] plantsPesticides = new int[n];

        for (int i = 0; i < plants.length; i++) {
            plantsPesticides[i] = Integer.parseInt(plants[i]);
        }

        int[] days = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 0; i < plantsPesticides.length; i++) {
            int maxDays = 0;
            while (stack.size() > 0 && plantsPesticides[stack.peek()] >= plantsPesticides[i]){
                maxDays = Math.max(maxDays, days[stack.pop()]);
            }

            if(stack.size() > 0){
                days[i] = maxDays +1;
            }
            stack.push(i);
        }

        Arrays.sort(days);
        int max = days[days.length - 1];
        System.out.println(max);
    }
}

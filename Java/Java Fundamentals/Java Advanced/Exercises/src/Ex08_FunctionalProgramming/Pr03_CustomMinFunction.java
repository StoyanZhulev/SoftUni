package Ex08_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Pr03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        System.out.println(findMinElement.apply(nums));

    }

    private static Function<int[],Integer> findMinElement = array -> {
        int minimum = Integer.MAX_VALUE;
        for(Integer num : array){
            if(minimum>num){
                minimum=num;
            }
        }
        return minimum;
    };
    
    
}

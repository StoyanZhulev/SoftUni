package Ex08_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Pr05_AppliedAritmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String op = reader.readLine();
        while(!"end".equals(op)){
            Function<Integer, Integer> func = function(op);
            if(!"print".equals(op)){
                operation(nums, func);
            }else{
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            op = reader.readLine();
        }
    }

    public static Function<Integer, Integer> function(String op){

        if("add".equals(op)){
            return num -> num += 1;
        }else if ("multiply".equals(op)){
            return num -> num *= 2;
        }else if("subtract".equals(op)){
            return num -> num -= 1;
        }
        return num -> num;
    }
    public static int[] operation(int[] nums, Function<Integer, Integer> func){

        //int[] result = new int[nums.length];

       for (int i = 0; i < nums.length; i++) {

           nums[i] = func.apply(nums[i]);
       }


        return nums;
    }
}

package Ex08_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Pr05_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<String, Integer, Integer> function = (x, y) -> {
            switch (x){
                case "add":
                    return y + 1;
                case "multiply":
                    return y *2;
                case "subtract":
                    return y -1;
                default:
                    return null;
            }

        };

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Consumer<int[]> printNums = x -> {
          StringBuilder sb = new StringBuilder();
            for (int aX : x) {
                sb.append(aX).append(" ");
            }
            System.out.println(sb.toString().trim());
        };

        String command = "";
        while (!"end".equals(command = reader.readLine())){

            if(!"print".equals(command)){
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = function.apply(command, nums[i]);
                }
            }else{
                printNums.accept(nums);
            }
        }
    }
}

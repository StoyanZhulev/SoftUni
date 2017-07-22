package Ex08_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Pr04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int first = input[0];
        int last = input[1];
        
        String evenOrOdd = reader.readLine();

       //if("even".equals(evenOrOdd)){
       //    printNums(first, last, num -> num % 2 == 0);
       //}else{
       //    printNums(first, last, num -> num % 2 != 0);
       //}

        printNums(first, last, evenOrOdd);
    }

    public static void printNums(int first, int last,String oddOrEven/*, Predicate<Integer> isTrue*/){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            nums.add(i);
        }

        if("even".equals(oddOrEven)){
            nums.stream()
                    .filter(num -> num % 2 == 0)
                    .forEach(num -> System.out.print(num + " "));
        }else{
            nums.stream()
                    .filter(num -> num % 2 != 0)
                    .forEach(num -> System.out.print(num + " "));
        }

      //ArrayList<Integer> result = new ArrayList<>();
      //for (Integer num : nums) {
      //    if(isTrue.test(num)){
      //        result.add(num);
      //    }
      //}

      //for (Integer integer : result) {
      //    System.out.print(integer + " ");
      //}
    }
}

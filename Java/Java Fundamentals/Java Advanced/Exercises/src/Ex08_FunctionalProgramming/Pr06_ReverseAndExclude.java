package Ex08_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pr06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        Collections.reverse(numbers);

       int n = Integer.parseInt(reader.readLine());
       //numbers.stream()
       //        .filter(num -> num % n != 0).collect(Collectors.toList()).forEach(number -> {
       //    System.out.print(number + " ");

       //});

        BiPredicate<Integer, Integer> isDivisable = (num, divider) -> num % divider == 0;

        ArrayList<Integer> finalList = new ArrayList<>();
        for (Integer number : numbers) {
            if (!isDivisable.test(number, n)) {
                finalList.add(number);
            }

        }

        for (Integer number : finalList) {
            System.out.print(number + " ");//}

        }
    }
}

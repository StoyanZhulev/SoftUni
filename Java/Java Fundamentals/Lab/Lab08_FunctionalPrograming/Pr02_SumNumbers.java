package Lab08_FunctionalPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Pr02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        Function<String, Integer> parser = num -> Integer.parseInt(num);

        int sum = 0;

        for (String s : input) {
            sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);

    }
}

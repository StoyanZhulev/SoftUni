package Pr04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().trim();
        List<Integer> nums = null;
        while (!"END".equals(input)){

            try{
                nums = Arrays.stream(input.trim().split("\\D+")).map(Integer::parseInt).collect(Collectors.toList());

            }catch (NumberFormatException nfe){}

            input = reader.readLine();
        }
        Lake lake = new Lake(nums);

        StringBuilder output = new StringBuilder();
        for (Integer integer : lake) {
            output.append(integer).append(", ");
        }

        output.delete(output.length() - 2, output.length());
        System.out.println(output);
    }
}

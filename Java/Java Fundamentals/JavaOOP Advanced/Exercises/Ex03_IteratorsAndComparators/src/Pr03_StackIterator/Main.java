package Pr03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        Stack stack = new Stack();
        while (!"END".equals(command)) {
            String type = command.split(" ")[0];
            switch (type) {
                case "Push":
                    int[] nums = Arrays.stream(command.substring(5).trim().split(", ")).mapToInt(Integer::parseInt).toArray();
                    for (int num : nums) {
                        stack.push(num);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (IllegalArgumentException iae ){
                        System.out.println(iae.getMessage());
                    }
                    break;
                default:
                    break;
            }
            command = reader.readLine();
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}

package Pr09_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<Integer> list = new CustomList<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] commandArgs = reader.readLine().split(" ");
            String commandType = commandArgs[0];
            int element = Integer.parseInt(commandArgs[1]);

            switch (commandType) {
                case "Add":
                    list.add(element);
                    break;
                case "Remove":
                    list.remove(element);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(list.getSize()).append(System.lineSeparator());
        for (Integer integer : list) {
            result.append(integer).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}

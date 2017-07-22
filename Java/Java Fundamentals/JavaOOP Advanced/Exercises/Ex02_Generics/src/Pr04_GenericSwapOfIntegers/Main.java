package Pr04_GenericSwapOfIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(reader.readLine()));
        }

        int[] swapIndexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index1 = swapIndexes[0];
        int index2 = swapIndexes[1];

        List<Integer> swaped = ListSwap.swap(list, index1, index2);

        ListSwap.print(swaped);
    }
}

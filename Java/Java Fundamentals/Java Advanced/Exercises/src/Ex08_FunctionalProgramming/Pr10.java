package Ex08_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pr10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Integer> dividers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean isDiv = true;

            for (Integer divider : dividers) {
                if(i % divider != 0){
                    isDiv = false;
                }
            }

            if(isDiv){
                System.out.print(i + " ");
            }
        }
    }
}

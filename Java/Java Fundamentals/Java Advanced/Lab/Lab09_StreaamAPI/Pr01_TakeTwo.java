package Lab09_StreaamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr01_TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(nums)
                .filter(n -> 10 <= n && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));
    }
}

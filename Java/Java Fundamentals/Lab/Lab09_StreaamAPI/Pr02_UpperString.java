package Lab09_StreaamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr02_UpperString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split(" ");

        Arrays.stream(text).map(String::toUpperCase).forEach(s -> System.out.print(s + " "));

    }
}

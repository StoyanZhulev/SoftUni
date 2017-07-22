package Ex06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr01_ReverseString {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        StringBuilder builder = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }

        System.out.println(builder);
    }
}

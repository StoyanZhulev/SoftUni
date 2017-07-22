package Lab06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr03_ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String upcase = "<upcase>";
        String upcaseClose = "</upcase>";

        while (input.contains(upcase)){
            int startIndex = input.indexOf(upcase);
            int endIndex = input.indexOf(upcaseClose);

            String remainder = input.substring(startIndex + upcase.length(), endIndex);
            input = input.replace(upcase + remainder + upcaseClose, remainder.toUpperCase());

        }

        System.out.println(input);
    }
}

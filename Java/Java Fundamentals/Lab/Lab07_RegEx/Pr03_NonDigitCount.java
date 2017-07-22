package Lab07_RegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_NonDigitCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Pattern pattern = Pattern.compile("[\\D]");//^\\d [^0-9]
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()){
            count++;
        }

        System.out.println("Non-digits: " + count);
    }
}

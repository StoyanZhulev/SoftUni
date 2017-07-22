package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(.)\\1{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()){
           String match = matcher.group(1);
            matcher.appendReplacement(buffer, match);
        }
        matcher.appendTail(buffer);
        System.out.println(buffer);
    }
}

package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr06_SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String text = scanner.nextLine();

        String regex = "([^.!?]+[.!?])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            if(matcher.group().contains(" " + word + " ")){
                System.out.println(matcher.group());
            }
        }
    }
}

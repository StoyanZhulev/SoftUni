package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr05_ExtractEmails {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String text = scn.nextLine();


        String regex = "((?<=\\s|^))([a-z0-9][a-z0-9\\-._]*[a-z0-9])@([a-z][a-z\\-]*[a-z]\\.)+[a-z]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

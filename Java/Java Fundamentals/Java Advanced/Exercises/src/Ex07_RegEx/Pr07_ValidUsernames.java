package Ex07_RegEx;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr07_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String splitRegex = "[\\\\ \\s/)(\\t]+";
        String[] array = text.split(splitRegex);


        String regex = "((?<=\\s)|^)([a-zA-Z][A-Za-z0-9_]{2,24}$)";
        Pattern pattern = Pattern.compile(regex);

        ArrayList<String> validUsernames = new ArrayList<>();
        for (String string : array) {
            Matcher matcher = pattern.matcher(string);

            if(matcher.find()){
                validUsernames.add(string);
            }
        }
        int maxLength = 0;
        int currLength = 0;
        String first = "";
        String second = "";
        for (int i = 0; i < validUsernames.size() - 1; i++) {
            currLength = validUsernames.get(i).length() + validUsernames.get(i + 1).length();
            if(currLength > maxLength){
                maxLength = currLength;
                first = validUsernames.get(i);
                second = validUsernames.get(i + 1);
            }
        }

        System.out.println(first);
        System.out.println(second);
    }
}

package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr10_UseYourChainsBuddy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "<p>(.*?)<\\/p>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String extractedText = "";

        while (matcher.find()){
            extractedText += matcher.group(1);
        }


        String replaceRegex = "[^a-z0-9]";
        extractedText = extractedText.replaceAll(replaceRegex, " ");

        extractedText = extractedText.replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder();

        for (char symbol : extractedText.toCharArray()) {
            if(symbol >= 'a' && symbol <= 'm'){
                sb.append((char)(symbol + 13));
            }else if(symbol >= 'n' && symbol <= 'z'){
                sb.append((char)(symbol - 13));
            }else{
                sb.append(symbol);
            }
        }

        System.out.println(sb.toString());
    }
}

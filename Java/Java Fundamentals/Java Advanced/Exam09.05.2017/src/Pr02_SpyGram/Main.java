package Pr02_SpyGram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String numbersAsString = reader.readLine();
        List<Integer> nums = new ArrayList<>();

        List<String[]> m = new ArrayList<>();

        char[] numsChars = numbersAsString.toCharArray();

        Pattern pattern = Pattern.compile("TO: ([A-Z]+); MESSAGE: (.*);");

        String line = reader.readLine();
        while (!"END".equals(line)){
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                String name = matcher.group(1);

                String encryptedMessage = encyptMessage(matcher.group(), numsChars);
                String[] tLIst = new String[]{name, encryptedMessage};
                m.add(tLIst);
            }
            line = reader.readLine();
        }

        m.stream().sorted((s1, s2) -> s1[0].compareTo(s2[0])).forEach(s -> System.out.println(s[1]));

    }

    private static String encyptMessage(String message, char[] numsChars) {
        StringBuilder sb = new StringBuilder();
        int numIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            int newChar = (int)message.charAt(i) + Integer.parseInt(String.valueOf(numsChars[numIndex]));
            char ch = (char)newChar;
            sb.append(String.valueOf(ch));
            numIndex++;
            if(numIndex == numsChars.length){
                numIndex = 0;
            }
        }
        return sb.toString();
    }
}

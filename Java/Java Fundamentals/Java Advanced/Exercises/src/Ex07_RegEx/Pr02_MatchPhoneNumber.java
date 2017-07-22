package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^\\+359(-| )2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        while (true){
            String number = scanner.nextLine();
            if("end".equals(number)){
                break;
            }

            Matcher matcher = pattern.matcher(number);
            if(matcher.find()){
                System.out.println(matcher.group(0));
            }

        }
    }
}

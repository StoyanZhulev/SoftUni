package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr01_MatchFullName {
    public static void main(String[] args) {
        Scanner Scanner  = new Scanner(System.in);

        String regex = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b";

        Pattern pattern = Pattern.compile(regex);

        while(true){
            String text = Scanner .nextLine();
            if("end".equals(text)){
                break;
            }

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                System.out.println(matcher.group(0));
            }
        }
    }

}

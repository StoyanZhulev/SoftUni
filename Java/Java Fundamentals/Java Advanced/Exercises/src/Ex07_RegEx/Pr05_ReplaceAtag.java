package Ex07_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr05_ReplaceAtag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<open><a)|(?<close></a>)";
        Pattern pattern = Pattern.compile(regex);
        StringBuffer buffer = new StringBuffer();
        while(true){
            String input = scanner.nextLine();
            if("end".equals(input)){
                break;
            }

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                if(matcher.group().equals(matcher.group("open"))){
                    matcher.appendReplacement(buffer, "[URL");
                }else{
                    matcher.appendReplacement(buffer, "[/URL]");
                }
            }
            matcher.appendTail(buffer);

        }
        System.out.println(buffer);

    }
}

package Ex06_ManualStringProccessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr16_ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while(true){
            String inputLine = scanner.nextLine();

            if("END".equals(inputLine)){
                break;
            }

            sb.append(inputLine);

        }

        String text = sb.toString();
        String newTExt = "";

        String regex = "<a\\s+(?:[^>]+)?href\\s*=\\s*(?:'([^']*)'|\"+([^\"]*)\"+|([^\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){

            for (int i = 1; i <= 3; i++) {
                if(matcher.group(i)!= null){
                    System.out.println(matcher.group(i));
                }
            }

        }
    }
}

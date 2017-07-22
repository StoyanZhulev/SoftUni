package Ex06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pr16_ExtractHyperlinkLab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line = "";
        while(!"END".equals(line = reader.readLine())){

            sb.append(line);
        }

        List<String> aTags = new ArrayList<>();

        String text = sb.toString();
        while(true){
            int startIndex = text.indexOf("<a");
            int endIndex = text.indexOf(">", startIndex + 1);

            if(startIndex == -1 || endIndex == -1){
                break;
            }

            aTags.add(text.substring(startIndex, endIndex +1));
            text = text.substring(endIndex + 1);
        }

        for (String aTag : aTags) {
            int hrefIndexx = aTag.indexOf("href") + 4;


            if (aTag.charAt(hrefIndexx - 5) != ' ') {
                continue;
            }
            while(hrefIndexx < aTag.length() && (aTag.charAt(hrefIndexx) == ' ')
                    || aTag.charAt(hrefIndexx) == '\t'
                    || aTag.charAt(hrefIndexx) == '\"'
                    | aTag.charAt(hrefIndexx) == '\''
                    || aTag.charAt(hrefIndexx) == '='){

                hrefIndexx++;
            }

            char delimiter = aTag.charAt(hrefIndexx - 1);

            int nextDelimiter = aTag.indexOf(delimiter, hrefIndexx +1);
            if(delimiter != ' ' && delimiter != '\t' && delimiter != '\'' && delimiter != '\"'){
                nextDelimiter = aTag.indexOf('>', hrefIndexx + 1);
            }

            if(nextDelimiter != -1){
                System.out.println(aTag.substring(hrefIndexx, nextDelimiter));
                continue;
            }
            if(delimiter == '='){
                delimiter = ' ';
            }


            nextDelimiter = aTag.indexOf(delimiter, hrefIndexx);
            if(nextDelimiter != -1){
                System.out.println(aTag.substring(hrefIndexx, nextDelimiter));
            }

        }
    }
}

package Ex07_RegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr07_PhoneNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        LinkedHashMap<String, String> phoneNumbers = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)[^a-zA-Z+]*?(?=\\+|[0-9]{2,})([0-9+]?[0-9][0-9.\\-)( /]*[0-9])");

        while(true){
            String line = reader.readLine();
            if("END".equals(line)){
                break;
            }
            sb.append(line);
        }

        Matcher matcher = pattern.matcher(sb);


        while (matcher.find()){
            String name = matcher.group(1);
            String number = matcher.group(2);
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                if(number.charAt(i) == '+'){
                    num.append(number.charAt(i));
                }

                if(Character.isDigit(number.charAt(i))){
                    num.append(number.charAt(i));
                }
            }

          //number = number.replace("(", "");
          //number = number.replace(")", "");
          //number = number.replace(".", "");
          //number = number.replace(",", "");
          //number = number.replace(" ", "");
          //number = number.replace("-", "");
          //number = number.replace("/", "");

                phoneNumbers.put(name, num.toString());

        }
        int count = 0;

        if(phoneNumbers.isEmpty()){
            System.out.println("<p>No matches!</p>");
        }else{
            System.out.print("<ol>");
            for (String name : phoneNumbers.keySet()) {
                if(count == phoneNumbers.size() - 1){
                    System.out.printf("<li><b>%s:</b> %s</li></ol>", name, phoneNumbers.get(name));
                }else{
                    System.out.printf("<li><b>%s:</b> %s</li>", name, phoneNumbers.get(name));
                }
                count++;
            }
        }

    }
}

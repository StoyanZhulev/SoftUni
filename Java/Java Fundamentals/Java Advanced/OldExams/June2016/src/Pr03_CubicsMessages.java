import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_CubicsMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String text = reader.readLine();

            if("Over!".equals(text)){
                break;
            }

            int n = Integer.parseInt(reader.readLine());

            Pattern pattern = Pattern.compile("^[0-9]+([a-zA-Z]{"+n+"})[^a-zA-Z]*$");

            Matcher matcher = pattern.matcher(text);

            if(matcher.find()){
                ArrayList<Integer> indexes = new ArrayList<>();
                for (int i = 0; i < matcher.group().length(); i++) {
                    if(Character.isDigit(matcher.group().charAt(i))){
                        indexes.add(Character.getNumericValue(matcher.group().charAt(i)));
                    }
                }

                String message = matcher.group(1);

                System.out.print(message + " == ");
                for (int i = 0; i < indexes.size(); i++) {

                    if(indexes.get(i) < message.length()){
                        System.out.print(message.charAt(indexes.get(i)));
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}

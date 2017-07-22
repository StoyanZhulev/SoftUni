package Ex09_StreamAPI_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr10_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<small>>-{5}>)|(?<medium>>>-{5}>)|(?<large>>>>-{5}>>)");

        int small = 0;
        int medium = 0;
        int large = 0;

        for (int i = 0; i < 4; i++) {
            String hay = reader.readLine();
            Matcher matcher = pattern.matcher(hay);

            while (matcher.find()){
                if(matcher.group("small") != null){
                    small++;
                }else if(matcher.group("medium") != null){
                    medium++;
                }else{
                    large++;
                }
            }
        }

        String num = "" + small + medium + large;

        String binary = Integer.toBinaryString(Integer.valueOf(num));

        StringBuilder sb = new StringBuilder();
        sb.append(binary);
        String reversed = sb.reverse().toString();

        sb.delete(0, sb.length());
        sb.append(binary);
        sb.append(reversed);
        int result = Integer.parseInt(sb.toString(),2);

        System.out.println(result);
    }
}

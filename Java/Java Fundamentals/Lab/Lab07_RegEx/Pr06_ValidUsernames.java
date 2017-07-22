package Lab07_RegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr06_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,16}$");

        String line = reader.readLine();
        while (!"END".equals(line)){
            Matcher matcehr = pattern.matcher(line);
            if(matcehr.find()){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }
            line = reader.readLine();
        }


    }
}

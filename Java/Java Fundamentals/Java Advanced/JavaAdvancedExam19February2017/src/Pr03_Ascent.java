import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_Ascent {

    private static String line = "";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(_|,)([A-Za-z]+)([0-9])");

        LinkedHashMap<String, String> m = new LinkedHashMap<>();



        line = reader.readLine();
        while (!"Ascend".equals(line)){
            for (String s : m.keySet()) {
                line = line.replaceAll(s, m.get(s));
            }
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String front = matcher.group(1);
                String matchedText = matcher.group(2);
                char[] charrArray = matchedText.toCharArray();
                int digit = Integer.parseInt(matcher.group(3));

                StringBuilder sb = new StringBuilder();
                if(front.equals(",")){
                    for (int i = 0; i < charrArray.length; i++) {
                        charrArray[i] = (char)(charrArray[i] + digit);
                        sb.append(charrArray[i]);
                    }
                }else{
                    for (int i = 0; i < charrArray.length; i++) {
                        charrArray[i] = (char)(charrArray[i] - digit);
                        sb.append(charrArray[i]);

                    }
                }
                String messege = sb.toString();
                m.put(matcher.group(), messege);

                line = line.replaceAll(matcher.group(), messege);


             //   matcher = pattern.matcher(line);
            }
            System.out.println(line);
            line = reader.readLine();
        }
    }
}

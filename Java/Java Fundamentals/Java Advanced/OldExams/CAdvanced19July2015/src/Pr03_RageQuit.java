import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_RageQuit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toUpperCase();
        Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
        Matcher macher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();

        while (macher.find()){
            String messege = macher.group(1);
            int count = Integer.parseInt(macher.group(2));

            for (int i = 0; i < count; i++) {
                sb.append(messege);
            }
        }

        HashSet<Character> unique = new HashSet<>();
        char[] arr = sb.toString().toCharArray();
        for (char anArr : arr) {
            unique.add(anArr);
        }
        int uniqueCount = unique.size();

        System.out.printf("Unique symbols used: %s%n", uniqueCount);
        System.out.println(sb);
    }
}

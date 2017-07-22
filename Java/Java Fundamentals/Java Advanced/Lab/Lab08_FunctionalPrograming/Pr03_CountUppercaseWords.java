package Lab08_FunctionalPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Pr03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().trim().split(" ");

        if(words[0].length() != 0) {

            Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

            ArrayList<String> result = new ArrayList<>();
            for (String word : words) {
                if (isUpperCase.test(word)) {
                    result.add(word);
                }
            }

            if(result.size() != 0){
                System.out.println(result.size());
            }
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}

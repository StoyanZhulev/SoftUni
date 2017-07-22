package Lab06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pr04_SpecialWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        String text = reader.readLine();

        HashMap<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            int count = 0;
            int index = text.indexOf(word);
            while (index != -1){
                count++;
                index = text.indexOf(word, index + 1);
            }
            wordsCount.put(word, count);
        }

        for (String word : wordsCount.keySet()) {
            System.out.printf("%s - %d%n", word, wordsCount.get(word));
        }
    }
}

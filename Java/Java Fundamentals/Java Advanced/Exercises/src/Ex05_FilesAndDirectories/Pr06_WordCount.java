package Ex05_FilesAndDirectories;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Pr06_WordCount {
    private final static String wordsPath = "/Exercises/src/resources/wordsPr06.txt";
    private final static String textPath = "/Exercises/src/resources/textPr06.txt";

    public static void main(String[] args) {
        String projctPath = System.getProperty("user.dir");
        String wordsFilePath = projctPath + wordsPath;
        String textFilePath = projctPath + textPath;
        String fileOutputPath = projctPath + "/Exercises/src/resources/outputPr06.txt";

        HashMap<String, Integer> wordsCount = new HashMap<>();
        HashMap<String, String> wordsOriginal = new HashMap<>();


        try(BufferedReader wordsreader = new BufferedReader(new FileReader(wordsFilePath));
            BufferedReader textreader = new BufferedReader(new FileReader(textFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutputPath))) {

            String line = "";
            while((line = wordsreader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if(!wordsCount.containsKey(wordKey)){
                        wordsCount.put(wordKey, 0);
                        wordsOriginal.put(wordKey, word);
                    }
                }
            }

            while((line = textreader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if(wordsCount.containsKey(wordKey)){
                       String key = wordKey;
                        Integer count = wordsCount.get(key) + 1;
                        wordsCount.put(key, count);
                    }
                }
            }


            wordsCount.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(pair -> {
                        try {
                            writer.write(String.format("%s - %d%n", wordsOriginal.get(pair.getKey()), pair.getValue()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

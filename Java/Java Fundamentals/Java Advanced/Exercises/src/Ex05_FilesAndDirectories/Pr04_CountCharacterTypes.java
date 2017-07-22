package Ex05_FilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pr04_CountCharacterTypes {
    private final static String path = "/Exercises/src/resources/input.txt";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr04.txt";

        Path input = Paths.get(filePath);
        int vowels = 0;
        int consts = 0;
        int punct = 0;
        try (BufferedReader reader = Files.newBufferedReader(input);
             PrintWriter writer = new PrintWriter(fileOutputPath)){

            String line = reader.readLine();

            while(line != null){
                for (char c : line.toCharArray()) {
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        vowels++;
                    }else if(Character.isLetter(c)){
                        consts++;
                    }else if(c == '!' || c == ',' || c == '.' || c == '?'){
                        punct++;
                    }
                }
                line = reader.readLine();
            }

            writer.println("Vowels: "+ vowels);
            writer.println("Constants: "+ consts);
            writer.println("Punctuation: "+ punct);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

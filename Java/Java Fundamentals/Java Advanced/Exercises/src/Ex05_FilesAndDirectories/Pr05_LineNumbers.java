package Ex05_FilesAndDirectories;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pr05_LineNumbers {
    private final static String path = "/Exercises/src/resources/input.txt";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr05.txt";

        Path input = Paths.get(filePath);

        try(PrintWriter writer = new PrintWriter(fileOutputPath)){
            List<String> lines = Files.readAllLines(input);
            for (int i = 0; i < lines.size(); i++) {
                writer.println(i+1 + ". "+ lines.get(i));
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}

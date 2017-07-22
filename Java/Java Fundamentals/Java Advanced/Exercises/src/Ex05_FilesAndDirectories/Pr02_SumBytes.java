package Ex05_FilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pr02_SumBytes {
    private final static String path = "/Exercises/src/resources/input.txt";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr02.txt";

        Path input = Paths.get(filePath);
        try(BufferedReader reader = Files.newBufferedReader(input);
            PrintWriter writer = new PrintWriter(fileOutputPath)){
            String line = reader.readLine();

            long sum = 0;
            while (line != null){
                for (char c : line.toCharArray()) {
                    sum+= c;
                }

                line = reader.readLine();
            }

            System.out.println(sum);
            writer.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

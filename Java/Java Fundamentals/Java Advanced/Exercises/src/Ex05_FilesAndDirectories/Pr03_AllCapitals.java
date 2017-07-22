package Ex05_FilesAndDirectories;

import java.io.*;
import java.nio.file.Files;

public class Pr03_AllCapitals {
    private final static String path = "/Exercises/src/resources/input.txt";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr03.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));
            PrintWriter writer = new PrintWriter(fileOutputPath)){

            String line = reader.readLine();
            while (line != null){
                for (char c : line.toCharArray()) {
                    c = Character.toUpperCase(c);
                    writer.print(c);
                }

                writer.println();
                line = reader.readLine();
            }



        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

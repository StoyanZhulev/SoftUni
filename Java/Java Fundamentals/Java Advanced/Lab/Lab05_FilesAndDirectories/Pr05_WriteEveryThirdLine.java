package Lab05_FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Pr05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\input.txt";
        String outputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Pr05\\output.txt";

        try(BufferedReader  reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(outputPath)){

            String line = reader.readLine();
            int counter = 1;
            while(line != null){
                if(counter % 3 == 0){
                    writer.println(line);
                }
                line = reader.readLine();
                counter++;
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}

package Lab05_FilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pr04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\input.txt";
        String outputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Pr04\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)){
            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        }catch (IOException e){
            e.getStackTrace();
        }
    }
}

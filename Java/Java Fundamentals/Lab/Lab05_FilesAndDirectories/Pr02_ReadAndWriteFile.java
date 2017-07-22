package Lab05_FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class Pr02_ReadAndWriteFile {
    public static void main(String[] args) {
        String inputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\input.txt";
        String outputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Pr02\\output.txt";

        HashSet<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try(FileInputStream fis = new FileInputStream(inputPath);
            FileOutputStream fos = new FileOutputStream(outputPath)){
            int oneByte = fis.read();
            while (oneByte >= 0){
                if(!punctuation.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        }catch (IOException e){

        }
    }
}

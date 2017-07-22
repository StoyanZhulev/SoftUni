package Lab05_FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pr03_CopyBytes {
    public static void main(String[] args) {
        String inputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\input.txt";
        String outputPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Pr03\\output.txt";

        try(FileInputStream fis = new FileInputStream(inputPath);
            FileOutputStream fos = new FileOutputStream(outputPath)){
                int oneByte = fis.read();
            while (oneByte >= 0){
                if(oneByte == ' ' || oneByte == '\n'){
                    fos.write(oneByte);
                }else{
                    String decimal = String.valueOf(oneByte);
                    for (char c : decimal.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}

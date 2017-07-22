package Lab05_FilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class Pr01_ReadFile {
    public static void main(String[] args) {
        String path = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\input.txt";

        try(FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();

            while (oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

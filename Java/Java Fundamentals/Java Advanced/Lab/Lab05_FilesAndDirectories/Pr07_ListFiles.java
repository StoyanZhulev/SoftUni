package Lab05_FilesAndDirectories;

import java.io.File;

public class Pr07_ListFiles {
    public static void main(String[] args) {
        final String stringPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Files-and-Streams";

        File file = new File(stringPath);

        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                if(!f.isDirectory()){
                    System.out.printf("%s: %s%n", f.getName(), f.length());
                }
            }
        }
    }
}

package Lab05_FilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class Pr08_NestedFolders {
    public static void main(String[] args) {
        final String stringPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Files-and-Streams";
        File file = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        int counter = 1;
        while(!queue.isEmpty()){
            File currentDir =  queue.poll();

            File[] nestedFiles = currentDir.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()){
                    queue.offer(nestedFile);
                    counter++;
                }
            }

            System.out.println(currentDir.getName());
        }

        System.out.println(counter + " folders");
    }
}

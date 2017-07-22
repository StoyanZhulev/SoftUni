package Ex05_FilesAndDirectories;

import java.io.*;

public class Pr09_CopyAPicture {
    private final static String path = "/Exercises/src/resources/testPic.jpg";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr09.jpg";


        //File image = new File("E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Excercises\\FilesAndFolders\\Pr09\\test.jpg");
       // File copiedImage = new File("E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Excercises\\FilesAndFolders\\Pr09\\copy-test.jpg");
        try(FileInputStream fis = new FileInputStream(filePath);
            FileOutputStream fos = new FileOutputStream(fileOutputPath)){
            int currentByte = fis.read();
            //byte[] buffer = new byte[1024];
            while(currentByte != -1){
                //currentByte = fis.read(buffer);
                //if(currentByte == -1){
                //    break;
                //}
                fos.write(currentByte);
                currentByte = fis.read();
               // fos.write(buffer, 0, bytesRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package Ex05_FilesAndDirectories;

import java.io.*;

public class Pr07_MergeTwoFiles {
    private final static String text1Path = "/Exercises/src/resources/text1Pr07.txt";
    private final static String text2Path = "/Exercises/src/resources/text2Pr07.txt";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String text1 = projectPath + text1Path;
        String text2 = projectPath + text2Path;
        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr07.txt";


        try(BufferedReader reader1 = new BufferedReader(new FileReader(text1));
            BufferedReader reader2 = new BufferedReader(new FileReader(text2));
            PrintWriter writer = new PrintWriter(fileOutputPath)) {
            String currLine = reader1.readLine();
            while(currLine != null){
                writer.println(currLine);
                currLine = reader1.readLine();
            }
            currLine = reader2.readLine();
            while(currLine != null){
                writer.println(currLine);
                currLine = reader2.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Ex05_FilesAndDirectories;

import java.io.*;

import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pr01_SumLines {
    private final static String path = "/Exercises/src/resources/input.txt";
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        String fileOutputPath = projectPath + "/Exercises/src/resources/outputPr01.txt";
       // File file = new File(filePath);

       // FileReader fileReader = new FileReader(file);
       // FileWriter writer = new FileWriter(file, true);
        //true - da zapishe;
        //false - da prezapishe faila;

       //try(BufferedReader reader = new BufferedReader(fileReader);){

       //    String line;

       //    while((line = reader.readLine()) != null){
       //        long sum = 0;
       //        for (char c : line.toCharArray()) {
       //            sum += c;
       //        }
       //        System.out.println(sum);
       //        line = reader.readLine();
       //    }
       //}catch (IOException e){
       //    e.printStackTrace();
       //}


      Path input = Paths.get(filePath);
      try(BufferedReader reader = Files.newBufferedReader(input);
          PrintWriter writer = new PrintWriter(fileOutputPath)){
          String line = reader.readLine();

          while (line != null){
              long sum = 0;
              for (char c : line.toCharArray()) {
                  sum+= c;
              }
              System.out.println(sum);
              writer.println(sum);
              line = reader.readLine();
          }
      }catch (IOException e){
          e.printStackTrace();
      }
    }
}

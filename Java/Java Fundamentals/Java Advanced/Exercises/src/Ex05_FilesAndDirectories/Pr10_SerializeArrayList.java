package Ex05_FilesAndDirectories;

import java.io.*;
import java.util.ArrayList;

public class Pr10_SerializeArrayList {
    private final static String path = "/Exercises/src/resources/listPr10.ser";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileInputPath = projectPath + "/Exercises/src/resources/listPr10.ser";

        ArrayList<Double> list = new ArrayList<>();
        for (double i = 0.0; i < 3.2; i+= 0.2) {
            list.add(i);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileInputPath))){
            ArrayList<Double> list1 = (ArrayList<Double>)ois.readObject();
            System.out.println(list1);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package Ex05_FilesAndDirectories;


import java.io.*;

public class Pr11_SerializeCustomObject {
    private final static String path = "/Exercises/src/resources/objectPr11.ser";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String fileInputPath = projectPath + "/Exercises/src/resources/objectPr11.ser";


        Course course1 = new Course();
        course1.name = "Java Advanced";
        course1.numberOfStudents = 50;

        Course course2 = new Course();
        course2.name = "Java OOP";
        course2.numberOfStudents = 30;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(course1);
            oos.writeObject(course2);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileInputPath))){
            Course loadedCourse1 = (Course) ois.readObject();
            Course loadedCourse2 = (Course) ois.readObject();

            System.out.println(loadedCourse1.name);
            System.out.println(loadedCourse2.name);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

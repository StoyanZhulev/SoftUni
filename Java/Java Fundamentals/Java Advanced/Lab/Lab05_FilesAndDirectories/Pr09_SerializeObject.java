package Lab05_FilesAndDirectories;


import java.io.*;

public class Pr09_SerializeObject {
    public static void main(String[] args) throws ClassNotFoundException {
        final String objectPath = "E:\\SoftUni\\Java Fundamentals\\Java Advanced\\Lab\\Usloviq\\Pr09\\object.ser";

        Cube cube = new Cube();
        cube.color = "green";
        cube.depth = 13;
        cube.width = 14;
        cube.height = 5;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))){
            oos.writeObject(cube);
        }catch (IOException e){
            e.getStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath))){
            Cube loadedCube = (Cube)(ois.readObject());
            System.out.println(loadedCube.color);
        }catch (IOException e){
            e.getStackTrace();
        }


    }

}

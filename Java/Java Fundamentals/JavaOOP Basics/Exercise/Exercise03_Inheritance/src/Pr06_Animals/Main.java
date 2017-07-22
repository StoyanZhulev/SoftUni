package Pr06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Animal> animals = new ArrayList<>();

        String animalType = reader.readLine();
        while (!"Beast!".equals(animalType)) {
            String[] animalArgs = reader.readLine().split(" ");
            try {
                String name;
                int age;
                String gender;
                switch (animalType) {
                    case "Dog":
                        name = animalArgs[0];
                        age = Integer.parseInt(animalArgs[1]);
                        gender = animalArgs[2];
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Cat":
                        name = animalArgs[0];
                        age = Integer.parseInt(animalArgs[1]);
                        gender = animalArgs[2];
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Frog":
                        name = animalArgs[0];
                        age = Integer.parseInt(animalArgs[1]);
                        gender = animalArgs[2];
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                    case "Kitten":
                        name = animalArgs[0];
                        age = Integer.parseInt(animalArgs[1]);
                        Kitten kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        name = animalArgs[0];
                        age = Integer.parseInt(animalArgs[1]);
                        Tomcat tomcat = new Tomcat(name, age);
                        animals.add(tomcat);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animalType = reader.readLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName());
            System.out.printf("%s %s %s%n",animal.getName(), animal.getAge(), animal.getGender());
            animal.produceSound();
        }
    }
}

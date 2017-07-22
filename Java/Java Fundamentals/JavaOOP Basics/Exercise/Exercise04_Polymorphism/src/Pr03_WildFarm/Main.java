package Pr03_WildFarm;

import Pr03_WildFarm.Animal.Cat;
import Pr03_WildFarm.Animal.Mouse;
import Pr03_WildFarm.Animal.Tiger;
import Pr03_WildFarm.Animal.Zebra;
import Pr03_WildFarm.Food.Food;
import Pr03_WildFarm.Food.Meat;
import Pr03_WildFarm.Food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animal = reader.readLine();

        while (!"End".equals(animal)){
            String[] animalArgs = animal.split(" ");
            String[] foodArgs = reader.readLine().split(" ");

            String animalType = animalArgs[0];
            String animalName = animalArgs[1];
            double animalWeight = Double.parseDouble(animalArgs[2]);
            String animalLivingRegion = animalArgs[3];
            String breed = "";
            if("Cat".equals(animalType)){
                breed = animalArgs[4];
            }

                Food food =makeFood(foodArgs);

                switch (animalType){
                    case "Cat":
                        Cat cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                        cat.makeSound();
                        try{
                            cat.eat(food);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                        System.out.println(cat.toString());
                        break;
                    case "Tiger":
                        Tiger tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        tiger.makeSound();
                        try{
                            tiger.eat(food);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                        System.out.println(tiger.toString());
                        break;
                    case "Mouse":
                        Mouse mouse = new Mouse( animalName,animalType, animalWeight, animalLivingRegion);
                        mouse.makeSound();
                        try{
                            mouse.eat(food);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                        System.out.println(mouse);
                        break;
                    case "Zebra":
                        Zebra zebra = new Zebra( animalName,animalType, animalWeight, animalLivingRegion);
                        zebra.makeSound();
                        try{
                            zebra.eat(food);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                        System.out.println(zebra);
                }


            animal = reader.readLine();
        }
    }

    private static Food makeFood(String[] foodArgs) {
        switch (foodArgs[0]){
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodArgs[1]));
            case "Meat":
                return  new Meat(Integer.parseInt(foodArgs[1]));
            default:
                return null;
        }

    }

}

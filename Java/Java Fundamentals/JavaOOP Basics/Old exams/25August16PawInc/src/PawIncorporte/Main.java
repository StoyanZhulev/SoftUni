package PawIncorporte;

import PawIncorporte.animal.Cat;
import PawIncorporte.animal.Dog;
import PawIncorporte.centers.AdoptionCenter;
import PawIncorporte.centers.CleansingCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Paw pawInc = new Paw();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!"Paw Paw Pawah".equals(input)){
            String[] inputArgs = input.split(" \\| ");
            String command = inputArgs[0];
            switch (command){
                case "RegisterCleansingCenter":
                    String cleaningCenterName = inputArgs[1];
                    execRegisterCleaningCenterCommand(cleaningCenterName);
                    break;
                case "RegisterAdoptionCenter":
                    String adoptionCenterName = inputArgs[1];
                    execRegisterAdoptionCenterCommand(adoptionCenterName);
                    break;
                case "RegisterDog":
                    execRegisterDogCommand(inputArgs);
                    break;
                case "RegisterCat":
                    execRegisterCatCommand(inputArgs);
                    break;
                case  "SendForCleansing":
                    execSendForCleansingCommand(inputArgs);
                    break;
                case "Cleanse":
                    execCleanseCommand(inputArgs);
                    break;
                case "Adopt":
                    execAdoptCommand(inputArgs);
            }


            input = reader.readLine();
        }

        System.out.println(pawInc);
    }

    private static void execAdoptCommand(String[] inputArgs) {
        String adoptionCenterName = inputArgs[1];
        AdoptionCenter adoptCenter = null;
        for (AdoptionCenter adoptionCenter : pawInc.getAdoptionCenters()) {
            if(adoptionCenter.getName().equals(adoptionCenterName)){
                adoptCenter = adoptionCenter;
            }
        }
        if (adoptCenter != null) {
            adoptCenter.adoptAnimal(pawInc);
        }
    }

    private static void execCleanseCommand(String[] inputArgs) {
        String cleansingCenterName = inputArgs[1];
        CleansingCenter cleansCenter = null;
        for (CleansingCenter cleanCenter : pawInc.getCleansingCenters()) {
            if(cleanCenter.getName().equals(cleansingCenterName)){
                cleansCenter = cleanCenter;
            }
        }
        if (cleansCenter != null) {
            cleansCenter.cleanseAnimal(pawInc);
        }
    }

    private static void execSendForCleansingCommand(String[] inputArgs) {
        String adoptionCenterName = inputArgs[1];
        String cleansingCenterName = inputArgs[2];

        AdoptionCenter adoptCenter = null;
        for (AdoptionCenter adoptionCenter : pawInc.getAdoptionCenters()) {
            if(adoptionCenter.getName().equals(adoptionCenterName)){
                adoptCenter = adoptionCenter;
            }
        }

        CleansingCenter cleansCenter = null;
        for (CleansingCenter cleanCenter : pawInc.getCleansingCenters()) {
            if(cleanCenter.getName().equals(cleansingCenterName)){
                cleansCenter = cleanCenter;
            }
        }

        if (adoptCenter != null) {
            adoptCenter.sendForCleansing(cleansCenter);
        }
    }

    private static void execRegisterCatCommand(String[] inputArgs) {
        String catName = inputArgs[1];
        String catAge = inputArgs[2];
        String intelligenceCoefficient = inputArgs[3];
        String adoptionCenterName = inputArgs[4];
        AdoptionCenter adoptCenter = null;
        for (AdoptionCenter adoptionCenter : pawInc.getAdoptionCenters()) {
            if(adoptionCenter.getName().equals(adoptionCenterName)){
                adoptCenter = adoptionCenter;
            }
        }

        Cat cat = new Cat(catName, catAge,adoptCenter, intelligenceCoefficient);
        if (adoptCenter != null) {
            adoptCenter.getAnimals().add(cat);
        }
    }

    private static void execRegisterDogCommand(String[] inputArgs) {
        String dogName = inputArgs[1];
        String dogAge = inputArgs[2];
        String learnedCommands = inputArgs[3];
        String adoptionCenterName = inputArgs[4];
        AdoptionCenter adoptCenter = null;
        for (AdoptionCenter adoptionCenter : pawInc.getAdoptionCenters()) {
            if(adoptionCenter.getName().equals(adoptionCenterName)){
                adoptCenter = adoptionCenter;
            }
        }

        Dog dog = new Dog(dogName, dogAge, learnedCommands,adoptCenter);
        if (adoptCenter != null) {
            adoptCenter.getAnimals().add(dog);
        }
    }

    private static void execRegisterAdoptionCenterCommand(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(adoptionCenterName);
        pawInc.addAdoptionCenter(adoptionCenter);
    }

    private static void execRegisterCleaningCenterCommand(String cleaningCenterName) {
        CleansingCenter cleansingCenter = new CleansingCenter(cleaningCenterName);
        pawInc.addCleansingCenter(cleansingCenter);
    }
}

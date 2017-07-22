package PawIncorporte.animal;

import PawIncorporte.centers.AdoptionCenter;

public class Dog extends Animal{
    private String learnedCommands;

    public Dog(String name, String age, String learnedCommands, AdoptionCenter adoptionCenter){
        super(name, age, adoptionCenter);
        this.learnedCommands = learnedCommands;
    }

}

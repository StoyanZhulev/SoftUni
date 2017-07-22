package PawIncorporte.animal;

import PawIncorporte.centers.AdoptionCenter;

public class Cat extends Animal{
    private String intelligence;
    public Cat(String name, String age, AdoptionCenter adoptionCenter, String intelligence) {
        super(name, age, adoptionCenter);
        this.intelligence = intelligence;
    }
}

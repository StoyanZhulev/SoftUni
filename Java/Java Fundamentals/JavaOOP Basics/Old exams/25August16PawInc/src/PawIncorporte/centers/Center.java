package PawIncorporte.centers;

import PawIncorporte.animal.Animal;

import java.util.*;

public abstract class Center {
    private String name;
    private List<Animal> animals;

    public Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    protected final void registerAnimal(Animal animal){
        this.getAnimals().add(animal);
    }

}

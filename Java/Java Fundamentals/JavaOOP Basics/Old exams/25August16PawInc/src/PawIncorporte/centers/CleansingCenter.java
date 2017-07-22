package PawIncorporte.centers;

import PawIncorporte.Paw;
import PawIncorporte.animal.Animal;

public class CleansingCenter extends Center{
    public CleansingCenter(String name){
        super(name);
    }


    public void cleanseAnimal(Paw pawInc){
        for (Animal animal : this.getAnimals()) {
            animal.setCleansingStatus("cleansed");
            animal.getAdoptionCenter().registerAnimal(animal);
            pawInc.cleanedAnimal(animal.getName());
        }
        this.getAnimals().clear();
    }



}

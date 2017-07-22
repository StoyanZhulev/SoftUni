package Pr03_WildFarm.Animal;

public abstract class Felime extends Mammal{

    public Felime(){

    }
    public Felime(String animalName, String animalType, double animalWeight, String livingregion) {
        super();
        this.setLivingRegion(livingregion);
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);

    }
}

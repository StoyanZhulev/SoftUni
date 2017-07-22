package Pr03_WildFarm.Animal;

import Pr03_WildFarm.Food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingregion, String breed) {
        super();
        super.setAnimalName(animalName);
        super.setAnimalType(animalType);
        super.setAnimalWeight(animalWeight);
        super.setLivingRegion(livingregion);
        this.setBreed(breed);
    }

    private String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.####################");

        return String.format("%s[%s, %s, %s, %s, %s]", this.getAnimalType(), this.getAnimalName(), this.getBreed(), format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());

    }
}

package Pr03_WildFarm.Animal;


import Pr03_WildFarm.Food.Food;

import java.text.DecimalFormat;

public class Mouse extends Mammal {


    public Mouse( String animalName,String animalType, double animalWeight, String livingRegion) {
        super( animalName, animalType,animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(!"Vegetable".equals(food.getFoodType())){
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", this.getAnimalType()));
        }
        System.out.println("A cheese was just eaten!");
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.####################");
        return String.format("%s[%s, %s, %s, %s]", this.getAnimalType(), this.getAnimalName(), format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}

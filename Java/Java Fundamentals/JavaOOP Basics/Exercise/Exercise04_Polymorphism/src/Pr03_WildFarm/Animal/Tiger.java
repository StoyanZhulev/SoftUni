package Pr03_WildFarm.Animal;

import Pr03_WildFarm.Food.Food;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    public Tiger(String animalName, String animalType, double animalWeight, String livingregion) {
        super(animalName, animalType, animalWeight, livingregion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(!"Meat".equals(food.getFoodType())){
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", this.getAnimalType()));
        }
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.####################");
        return String.format("%s[%s, %s, %s, %s]", this.getAnimalType(), this.getAnimalName(), format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}

package Pr03_WildFarm.Food;

public abstract class Food {
    private int quantity;
    private String foodType;

    public Food(int quantity, String foodType){
        this.quantity = quantity;
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFoodType() {
        return foodType;
    }
}

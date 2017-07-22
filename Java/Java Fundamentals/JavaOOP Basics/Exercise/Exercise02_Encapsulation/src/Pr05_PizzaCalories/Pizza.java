package Pr05_PizzaCalories;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Dough pizzaDough;
    private ArrayList<Topping> pizzaToppings;
    private double totalCalories;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings){
        this.name = name;
        this.setNumberOfToppings(numberOfToppings);
        this.pizzaToppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.length() == 0 || name.length() < 1 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public ArrayList<Topping> getPizzaToppings() {
        return pizzaToppings;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings <0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public double getTotalCalories() {
        this.setTotalCalories(this.getPizzaToppings());
        return totalCalories;
    }

    private void setTotalCalories(ArrayList<Topping> toppings) {
        double calories = 0;
        for (Topping topping : toppings) {
            calories+=topping.getToppingCalories();
        }

        calories+= this.pizzaDough.getDoughCalories();
        this.totalCalories = calories;
    }

    public void addTopping(Topping topping){
        pizzaToppings.add(topping);
    }

    public void setPizzaDough(Dough pizzaDough) {
        this.pizzaDough = pizzaDough;
    }
}

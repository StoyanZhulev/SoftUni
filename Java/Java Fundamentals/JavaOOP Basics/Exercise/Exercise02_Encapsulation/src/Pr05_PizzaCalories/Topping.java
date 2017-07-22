package Pr05_PizzaCalories;

public class Topping {
    private final double toppingInitialCalories = 2.0;

    private String toppingType;
    private double toppingCalories;
    private double weight;


    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight, toppingType);
        this.setToppingCalories(weight, toppingType);
    }

    public double getToppingCalories() {
        return toppingCalories;
    }

    private void setToppingType(String toppingType) {
        if(!"Meat".equalsIgnoreCase(toppingType) && !"Veggies".equalsIgnoreCase(toppingType) && !"Cheese".equalsIgnoreCase(toppingType) && !"Sauce".equalsIgnoreCase(toppingType)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setToppingCalories(double weight, String toppingType) {

        double toppingCalories = 0;
        switch (toppingType.toLowerCase()){
            case "meat":
                toppingCalories = 1.2;
                break;
            case "veggies":
                toppingCalories = 0.8;
                break;
            case "cheese":
                toppingCalories = 1.1;
                break;
            case "sauce":
                toppingCalories = 0.9;
        }


        this.toppingCalories = toppingInitialCalories * toppingCalories * weight;
    }

    private void setWeight(double weight, String toppingType) {
        if(1 > weight || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }
}

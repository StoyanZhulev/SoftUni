package Pr03_CoffeeMachine;

public class Coffee {
    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(String coffeeSize, String coffeeType) {
        this.coffeeSize = CoffeeSize.valueOf(coffeeSize.toUpperCase());
        this.coffeeType = CoffeeType.valueOf(coffeeType.toUpperCase());
    }

    public int getPrice(){
        return this.coffeeSize.getPrice();
    }
}

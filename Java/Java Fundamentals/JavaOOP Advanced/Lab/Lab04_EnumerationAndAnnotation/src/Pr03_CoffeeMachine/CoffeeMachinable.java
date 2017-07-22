package Pr03_CoffeeMachine;

public interface CoffeeMachinable {
    void buyCoffee(String size, String type);

    void insertCoin(String coin);

    Iterable<Coffee> coffeesSold();
}

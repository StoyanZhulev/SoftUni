package Pr03_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine implements CoffeeMachinable {
    private List<Coffee> coffeeSold;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeeSold = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    @Override
    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);
        int totalCoins= this.coins.stream().mapToInt(Coin::getValue).sum();
        if(totalCoins > coffee.getPrice()){
            this.coffeeSold.add(coffee);
            this.coins.clear();
        }
    }

    @Override
    public void insertCoin(String coin) {
        Coin currCoin = Coin.valueOf(coin.toUpperCase());
        this.coins.add(currCoin);
    }

    @Override
    public Iterable<Coffee> coffeesSold() {
        return this.coffeeSold;
    }
}

package Pr04_ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    private void setName(String name) {
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product){
        if(this.getMoney() < product.getCost()){
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        this.money -= product.getCost();
        this.products.add(product);
        this.printBought(product);
    }

    private void printBought(Product product){
        System.out.println(this.getName() + " bought "+ product.getName());
    }
}

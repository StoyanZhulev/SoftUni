package Pr03_CarShopExtended;

import java.io.Serializable;

public class Seat implements Car,Sellable,Serializable{
    private String countryProduction;
    private String model;
    private String color;
    private int horsePower;
    private double price;

    public Seat(String model, String color, Integer horsePower, String countryProduction, Double price) {
        this.countryProduction = countryProduction;
        this.model = model;
        this.horsePower = horsePower;
        this.color = color;
        this.price = price;
    }

    public String getCountryProduction() {
        return countryProduction;
    }


    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires", this.model, this.countryProduction, Car.TYRES);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}

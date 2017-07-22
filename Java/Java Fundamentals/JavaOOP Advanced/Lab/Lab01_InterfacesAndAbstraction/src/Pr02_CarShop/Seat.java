package Pr02_CarShop;

import java.io.Serializable;

public class Seat implements Serializable, Car{
    private String countryProduction;
    private String model;
    private String color;
    private int horsePower;

    public Seat(String countryProduction, String model, Integer horsePower, String color) {
        this.countryProduction = countryProduction;
        this.model = model;
        this.horsePower = horsePower;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public int getHorsePower() {
        return 0;
    }
}

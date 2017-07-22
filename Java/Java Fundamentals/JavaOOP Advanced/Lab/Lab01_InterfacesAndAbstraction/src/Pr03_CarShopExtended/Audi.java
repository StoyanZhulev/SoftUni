package Pr03_CarShopExtended;

public class Audi implements Rentable{
    private String countryProduction;
    private String model;
    private String color;
    private int horsePower;
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduction, Integer minRentDay, Double pricePerDay) {
        this.countryProduction = countryProduction;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }



    public String getCountryProduction() {
        return countryProduction;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
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
    public int getMinRentDay() {
        return this.minRentDay;
    }


}

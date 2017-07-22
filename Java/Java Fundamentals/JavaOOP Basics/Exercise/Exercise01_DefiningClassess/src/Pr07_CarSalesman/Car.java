package Pr07_CarSalesman;

public class Car {
    private  String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine){
        this(model, engine, "n/a", "n/a");
    }

    public Car(String model, Engine engine, String color){
        this(model, engine, "n/a", color);
    }

    public Car(String model, Engine engine, int weight){
        this(model, engine, weight+ "", "n/a");
    }

    public Car(String model, Engine engine, String weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

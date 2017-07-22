package Pr07_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power){
        this(model, power, "n/a", "n/a");
    }

    public Engine(String model, int power, String efficiency){
        this(model, power, "n/a", efficiency);
    }

    public Engine(String model, int power, int displacement){

            this(model, power, displacement + "", "n/a");
    }

    public Engine(String model, int power, String displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}

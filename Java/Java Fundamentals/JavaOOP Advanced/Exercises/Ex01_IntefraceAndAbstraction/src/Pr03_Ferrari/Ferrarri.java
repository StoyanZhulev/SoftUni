package Pr03_Ferrari;

public class Ferrarri implements Car {
    private String driverName;
    private String model;

    public Ferrarri(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String getName() {
        return this.driverName;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!";
    }
}

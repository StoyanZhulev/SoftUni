package Pr01_Vehicles;

public abstract class Vehicle {
    private double fuelCapacity;
    private double consumptionPerKm;


    public Vehicle(double fuelCapacity, double consumption){
        this.setConsumptionPerKm(consumption);
        this.setFuelCapacity(fuelCapacity);
    }

    protected double getConsumptionPerKm(){
        return this.consumptionPerKm;
    }

    protected void setConsumptionPerKm(double consumptionPerKm){
        this.consumptionPerKm = consumptionPerKm;
    }

    protected double getFuelCapacity(){
        return this.fuelCapacity;
    }

    protected void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    protected abstract void refuelCapacity(double fuelCapacity);
    protected abstract void driveDistance(double distance);
}

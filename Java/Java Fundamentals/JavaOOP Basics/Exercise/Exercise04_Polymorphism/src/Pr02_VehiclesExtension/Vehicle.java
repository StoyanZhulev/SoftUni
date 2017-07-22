package Pr02_VehiclesExtension;

public abstract class Vehicle {
    private double fuelCapacity;
    private double consumptionPerKm;
    private double tankCapacity;


    public Vehicle(double fuelCapacity, double consumption, double tankCapacity){
        this.setConsumptionPerKm(consumption);
        this.setFuelCapacity(fuelCapacity);
        this.setTankCapacity(tankCapacity);
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
        if(tankCapacity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelCapacity = fuelCapacity;
    }

    protected double getTankCapacity() {

        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        if(tankCapacity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    protected abstract void refuelCapacity(double fuelCapacity);
    protected abstract void driveDistance(double distance);
}
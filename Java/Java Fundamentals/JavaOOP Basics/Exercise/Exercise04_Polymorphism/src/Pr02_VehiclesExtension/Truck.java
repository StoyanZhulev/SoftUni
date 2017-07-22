package Pr02_VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelCapacity, double consumption, double tankCapacity){
        super(fuelCapacity, consumption, tankCapacity);
        this.setConsumptionPerKm(consumption);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 1.6);
    }

    @Override
    protected void refuelCapacity(double fuel) {
        this.setFuelCapacity(this.getFuelCapacity() + fuel * 0.95);
    }

    @Override
    protected void driveDistance(double distance) {
        if (distance * this.getConsumptionPerKm() > this.getFuelCapacity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        }

        if((this.getFuelCapacity() - distance * this.getConsumptionPerKm()) < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelCapacity(this.getFuelCapacity() - distance * this.getConsumptionPerKm());
        DecimalFormat format = new DecimalFormat("#.#########################");
        System.out.printf("Truck travelled %s km",  format.format(distance));


    }
}
